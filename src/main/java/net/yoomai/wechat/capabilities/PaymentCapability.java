/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import net.yoomai.wechat.beans.payment.*;
import net.yoomai.wechat.beans.payment.bizpay.BizpayParams;
import net.yoomai.wechat.beans.payment.bizpay.BizpayResponse;
import net.yoomai.wechat.commands.Command;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.converts.AppConvert;
import net.yoomai.wechat.converts.PayConvert;
import net.yoomai.wechat.exceptions.ConvertException;
import net.yoomai.wechat.exceptions.OrderQueryException;
import net.yoomai.wechat.exceptions.PaymentException;
import net.yoomai.wechat.utils.StringUtils;
import net.yoomai.wechat.utils.WebUtils;
import org.apache.http.conn.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付能力
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PaymentCapability.java 1.0 27/11/2015
 */
public class PaymentCapability extends AbstractCapability {
    private static final Logger log = LoggerFactory.getLogger(PaymentCapability.class);

    private AppConvert convert;
    /**
     * 预付订单下单地址
     */
    private static final String _PREPAYMENT_URL_ = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 订单查询地址
     */
    private static final String _ORDER_QUERY_URL_ = "https://api.mch.weixin.qq.com/pay/orderquery";

    /**
     * 退款申请地址
     */
    private static final String _REFUND_URL_ = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    /**
     * 企业付款
     */
    private static final String _MK_TRANSFERS_URL_ = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

    /**
     * 企业付款查询
     */
    private static final String _MK_TRANSFER_QUERY_URL_ = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

    /**
     * 默认的转换模块是payconvert
     */
    public PaymentCapability() {
        this.convert = new PayConvert();
    }

    /**
     * 可重新定义转换模块
     *
     * @param convert
     */
    public PaymentCapability(AppConvert convert) {
        this.convert = convert;
    }

    /**
     * 生成预付订单接口
     *
     * @param body
     * @param outTradeNo
     * @param totalFee
     * @param ip
     * @param tradeType
     * @param openId
     * @return
     */
    public PayStatus prepayment(String body, String outTradeNo, int totalFee, String ip, String tradeType,
                                String openId) throws ConvertException {
        String nonceStr = StringUtils.randomString(8);
        // 此处写的好不优雅，有时间的话调整一下吧，OMG
        Map<String, Object> params = new HashMap<>();
        params.put("appid", wxConfig.getAppid());
        params.put("body", body);
        params.put("mch_id", wxConfig.getMchid());
        params.put("nonce_str", nonceStr);
        params.put("notify_url", wxConfig.getNofityURL());
        params.put("openid", openId);
        params.put("out_trade_no", outTradeNo);
        params.put("spbill_create_ip", ip);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("trade_type", tradeType);
        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();

        String sign = StringUtils.signature(buffer, "MD5", true);

        PayParams payParams = new PayParams(
                wxConfig.getAppid(), wxConfig.getMchid(), nonceStr, sign, body, outTradeNo, totalFee, ip,
                wxConfig.getNofityURL(), tradeType, openId
        );

        String params_xml_format = convert.reverse(payParams);
        log.debug("提交的支付参数: {}", params_xml_format);
        String ret = WebUtils.post(_PREPAYMENT_URL_, params_xml_format, WechatConfig._DATA_XML_, false, null);

        PayStatus payStatus = convert.convert(ret, PayStatus.class);
        return payStatus;
    }

    /**
     * 计算支付签名
     *
     * @param timestamp
     * @param nonceStr
     * @param prepayid
     * @param signType
     * @return
     */
    public String paySign(String timestamp, String nonceStr, String prepayid, String signType) {
        Map<String, Object> params = new HashMap<>();
        params.put("appId", wxConfig.getAppid());
        params.put("nonceStr", nonceStr);
        params.put("package", "prepay_id=" + prepayid);
        params.put("signType", signType);
        params.put("timeStamp", timestamp);
        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();

        String sign = StringUtils.signature(buffer, "MD5", true);
        return sign;
    }

    /**
     * 接收点对点支付状况的通知
     *
     * @param payMessage
     * @return
     */
    public PayResponse accept(String payMessage, Command command) throws ConvertException {
        NotifyStatus notifyStatus = convert.convert(payMessage, NotifyStatus.class);

        if ("SUCCESS".equals(notifyStatus.getReturnCode())) {
            command.execute(notifyStatus);
        }

        return new PayResponse("SUCCESS", "OK");
    }

    /**
     * 根据订单号或者交易流水号查询订单信息
     *
     * @param outTradeNo
     * @param transactionId
     * @return
     * @throws OrderQueryException
     */
    public OrderQueryResponse orderQuery(String outTradeNo) throws OrderQueryException, ConvertException {
        if (outTradeNo == null || "".equals(outTradeNo.trim())) {
            throw new OrderQueryException("系统订单号和微信支付流水号只能填一个");
        }

        String nonceStr = StringUtils.randomString(8);
        // 及其不优雅的代码又一次出现
        Map<String, Object> params = new HashMap<>();
        params.put("appid", wxConfig.getAppid());
        params.put("mch_id", wxConfig.getMchid());
        params.put("out_trade_no", outTradeNo);
        params.put("nonce_str", nonceStr);
        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();
        String sign = StringUtils.signature(buffer, "MD5", true);

        OrderQueryParams orderQueryParams = new OrderQueryParams(
                wxConfig.getAppid(), wxConfig.getMchid(), outTradeNo, nonceStr, sign
        );
        String params_xml_format = convert.reverse(orderQueryParams);
        String ret = WebUtils.post(_ORDER_QUERY_URL_, params_xml_format, WechatConfig._DATA_XML_, false, null);

        return convert.convert(ret, OrderQueryResponse.class);
    }

    /**
     * 申请退款
     *
     * @param outTradeNo
     * @param refundNo
     * @param totalFee
     * @param refundFee
     * @param opUserId
     * @return
     */
    public RefundResponse refund(String outTradeNo, String refundNo, int totalFee, int refundFee, String opUserId)
            throws ConvertException, PaymentException {
        String nonceStr = StringUtils.randomString(8);
        Map<String, Object> params = new HashMap<>();
        params.put("appid", wxConfig.getAppid());
        params.put("mch_id", wxConfig.getMchid());
        params.put("nonce_str", nonceStr);
        params.put("out_trade_no", outTradeNo);
        params.put("out_refund_no", refundNo);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("refund_fee", String.valueOf(refundFee));
        params.put("op_user_id", opUserId);
        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();
        String sign = StringUtils.signature(buffer, "MD5", true);

        RefundParams refundParams = new RefundParams(
                wxConfig.getAppid(), wxConfig.getMchid(), nonceStr, sign, outTradeNo, refundNo, totalFee,
                refundFee, opUserId
        );
        String params_xml_form = convert.reverse(refundParams);
        // 初始化证书, 证书位置为classes目录
        SSLContext sslContext = initSSLContext();

        String ret = WebUtils.post(_REFUND_URL_, params_xml_form, WechatConfig._DATA_XML_, true, sslContext);

        return convert.convert(ret, RefundResponse.class);
    }

    /**
     * 生成扫码支付所用的链接地址
     *
     * @param productId
     * @param timestamp
     * @param nonceStr
     * @return
     */
    public String generateBizpayURL(String productId, String timestamp, String nonceStr) {
        String bizpayURL = "weixin://wxpay/bizpayurl";

        Map<String, Object> params = new HashMap<>();
        params.put("appid", wxConfig.getAppid());
        params.put("mch_id", wxConfig.getMchid());
        params.put("time_stamp", timestamp);
        params.put("nonce_str", nonceStr);
        params.put("product_id", productId);

        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();
        String sign = StringUtils.signature(buffer, "MD5", true);

        bizpayURL += "?sign=" + sign + "&appid=" + wxConfig.getAppid() + "&mch_id=" + wxConfig.getMchid() +
                "&product_id=" + productId + "&time_stamp=" + timestamp + "&nonce_str=" + nonceStr;

        return bizpayURL;
    }

    /**
     * 将xml信息转换为扫码支付的请求参数对象
     *
     * @param content
     * @return
     * @throws ConvertException
     */
    public BizpayParams getBizpayParams(String content) throws ConvertException {
        return convert.convert(content, BizpayParams.class);
    }

    /**
     * 通过统一下单接口返回的信息,生成扫码支付的回应信息
     *
     * @param payStatus
     * @return
     */
    public BizpayResponse getBizpayResponse(PayStatus payStatus) {
        Map<String, Object> params = new HashMap<>();
        params.put("return_code", payStatus.getReturnCode());
        params.put("return_msg", payStatus.getReturnMsg());
        params.put("appid", payStatus.getAppId());
        params.put("mch_id", payStatus.getMchId());
        params.put("nonce_str", payStatus.getNonceStr());
        params.put("prepay_id", payStatus.getPrepayId());
        params.put("result_code", payStatus.getResultCode());
        if ("FAIL".equals(payStatus.getResultCode())) {
            params.put("err_code_des", payStatus.getErrorCodeDesc());
        }
        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();
        String sign = StringUtils.signature(buffer, "MD5", true);

        BizpayResponse bizpayResponse = new BizpayResponse(payStatus.getReturnCode(), payStatus.getReturnMsg(),
                payStatus.getAppId(), payStatus.getMchId(), payStatus.getNonceStr(), payStatus.getPrepayId(),
                payStatus.getResultCode(), payStatus.getErrorCodeDesc(), sign);
        return bizpayResponse;
    }

    /**
     * 进行企业支付付款操作
     *
     * @param tradeNo
     * @param openid
     * @param amount
     * @param desc
     * @param ip
     * @return
     */
    public TransferResponse mkTransfer(String tradeNo, String openid, int amount, String desc, String ip) throws PaymentException, ConvertException {
        String nonceStr = StringUtils.randomString(16);

        Map<String, Object> params = new HashMap<>();
        params.put("mch_appid", wxConfig.getAppid());
        params.put("mchid", wxConfig.getMchid());
        params.put("nonce_str", nonceStr);
        params.put("partner_trade_no", tradeNo);
        params.put("openid", openid);
        params.put("check_name", "NO_CHECK");
        params.put("amount", amount);
        params.put("desc", desc);
        params.put("spbill_create_ip", ip);
        String buffer = StringUtils.generateQueryString(params, true);
        buffer += "&key=" + wxConfig.getMchKey();
        String sign = StringUtils.signature(buffer, "MD5", true);

        TransferParams transferParams = new TransferParams(wxConfig.getAppid(), wxConfig.getMchid(), nonceStr, sign, tradeNo, openid,
                "OPTION_CHECK", amount, desc, ip);
        SSLContext sslContext = initSSLContext();
        String params_xml_form = convert.reverse(transferParams);
        String ret = WebUtils.post(_MK_TRANSFERS_URL_, params_xml_form, WechatConfig._DATA_XML_, true, sslContext);

        return convert.convert(ret, TransferResponse.class);
    }



    /* $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
    /*         Private Methods         */
    /* $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */

    /**
     * 初始化SSL证书
     *
     * @return
     * @throws PaymentException
     */
    private SSLContext initSSLContext() throws PaymentException {
        // 初始化证书, 证书位置为classes目录
        SSLContext sslContext = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream inputStream = new FileInputStream(new File(wxConfig.getMchPKCs()));
            keyStore.load(inputStream, wxConfig.getMchid().toCharArray());
            // Trust own CA and all self-signed certs
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, wxConfig.getMchid().toCharArray())
                    .build();
        } catch (Exception e) {
            throw new PaymentException("在进行退款时发生了证书初始化错误.", e);
        }

        return sslContext;
    }
}

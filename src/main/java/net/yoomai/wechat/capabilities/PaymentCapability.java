/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import net.yoomai.wechat.beans.payment.*;
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
public class PaymentCapability {
    private AppConvert convert;
    private String mch_id;
    private String mch_key;
    private String mch_cert;
    private String pay_notify_url;

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
     * 默认的转换模块是payconvert
     */
    public PaymentCapability() {
        this.convert = new PayConvert();
        this.mch_id = WechatConfig._WX_MCHID_;
        this.mch_key = WechatConfig._WX_MCH_KEY_;
        this.mch_cert = WechatConfig._WX_MCHID_PKCS_;
        this.pay_notify_url = WechatConfig._PAY_NOTIFY_URL_;
    }

    /**
     * 可重新定义转换模块
     *
     * @param convert
     */
    public PaymentCapability(AppConvert convert) {
        this.convert = convert;
        this.mch_id = WechatConfig._WX_MCHID_;
        this.mch_key = WechatConfig._WX_MCH_KEY_;
        this.mch_cert = WechatConfig._WX_MCHID_PKCS_;
        this.pay_notify_url = WechatConfig._PAY_NOTIFY_URL_;
    }

    /**
     * 初始化支付所需相关参数，如果不调用，则用默认的参数
     *
     * @param mch_id
     * @param mch_key
     * @param mch_cert
     * @param pay_notify_url
     */
    public void init(String mch_id, String mch_key, String mch_cert, String pay_notify_url) {
        this.mch_id = mch_id;
        this.mch_key = mch_key;
        this.mch_cert = mch_cert;
        this.pay_notify_url = pay_notify_url;
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
        params.put("appid",WechatConfig._APP_ID_);
        params.put("body", body);
        params.put("mch_id", this.mch_id);
        params.put("nonce_str", nonceStr);
        params.put("notify_url", this.pay_notify_url);
        params.put("openid", openId);
        params.put("out_trade_no", outTradeNo);
        params.put("spbill_create_ip", ip);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("trade_type", tradeType);
        params.put("key", this.mch_key);
        String sign = StringUtils.signature(params, "MD5", true);

        PayParams payParams = new PayParams(
                WechatConfig._APP_ID_, this.mch_id, nonceStr, sign, body, outTradeNo, totalFee, ip,
                this.pay_notify_url, tradeType, openId
        );

        String params_xml_format = convert.reverse(payParams);
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
        Map<String, String> params = new HashMap<>();
        params.put("appId", WechatConfig._APP_ID_);
        params.put("nonceStr", nonceStr);
        params.put("package", "prepay_id=" + prepayid);
        params.put("signType", signType);
        params.put("timeStamp", timestamp);
        params.put("key", WechatConfig._WX_MCH_KEY_);

        String sign = StringUtils.signature(params, "MD5", true);
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
        params.put("appid", WechatConfig._APP_ID_);
        params.put("mch_id", this.mch_id);
        params.put("out_trade_no", outTradeNo);
        params.put("nonce_str", nonceStr);
        params.put("key", this.mch_key);
        String sign = StringUtils.signature(params, "MD5", true);

        OrderQueryParams orderQueryParams = new OrderQueryParams(
                WechatConfig._APP_ID_, this.mch_id, outTradeNo, nonceStr, sign
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
        params.put("appid", WechatConfig._APP_ID_);
        params.put("mch_id", this.mch_id);
        params.put("nonce_str", nonceStr);
        params.put("out_trade_no", outTradeNo);
        params.put("out_refund_no", refundNo);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("refund_fee", String.valueOf(refundFee));
        params.put("op_user_id", opUserId);
        params.put("key", this.mch_key);
        String sign = StringUtils.signature(params, "MD5", true);

        RefundParams refundParams = new RefundParams(
                WechatConfig._APP_ID_, this.mch_id, nonceStr, sign, outTradeNo, refundNo, totalFee,
                refundFee, opUserId
        );
        String params_xml_form = convert.reverse(refundParams);
        // 初始化证书, 证书位置为classes目录
        SSLContext sslContext = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream inputStream = new FileInputStream(new File(this.mch_cert));
            keyStore.load(inputStream, this.mch_id.toCharArray());
            // Trust own CA and all self-signed certs
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, this.mch_id.toCharArray())
                    .build();
        } catch (Exception e) {
            throw new PaymentException("在进行退款时发生了证书初始化错误.", e);
        }

        String ret = WebUtils.post(_REFUND_URL_, params_xml_form, WechatConfig._DATA_XML_, true, sslContext);

        return convert.convert(ret, RefundResponse.class);
    }
}

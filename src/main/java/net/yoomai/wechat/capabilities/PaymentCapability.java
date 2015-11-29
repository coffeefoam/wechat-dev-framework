/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import net.yoomai.wechat.beans.payment.*;
import net.yoomai.wechat.commands.Command;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.converts.AppConvert;
import net.yoomai.wechat.exceptions.OrderQueryException;
import net.yoomai.wechat.utils.StringUtils;
import net.yoomai.wechat.utils.WebUtils;

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

    public void setConvert(AppConvert convert) {
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
                                String openId) {
        String nonceStr = StringUtils.randomString(8);
        // 此处写的好不优雅，有时间的话调整一下吧，OMG
        Map<String, Object> params = new HashMap<>();
        params.put("appid",WechatConfig._APP_ID_);
        params.put("body", body);
        params.put("mch_id", WechatConfig._WX_MCHID_);
        params.put("nonce_str", nonceStr);
        params.put("notify_url", WechatConfig._PAY_NOTIFY_URL_);
        params.put("openid", openId);
        params.put("out_trade_no", outTradeNo);
        params.put("spbill_create_ip", ip);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("trade_type", tradeType);
        params.put("key", WechatConfig._WX_MCH_KEY_);
        String sign = StringUtils.signature(params, "MD5", true);

        PayParams payParams = new PayParams(
                WechatConfig._APP_ID_, WechatConfig._WX_MCHID_, nonceStr, sign, body, outTradeNo, totalFee, ip,
                WechatConfig._PAY_NOTIFY_URL_, tradeType, openId
        );

        String params_xml_format = convert.reverse(payParams);
        String ret = WebUtils.post(_PREPAYMENT_URL_, params_xml_format, WechatConfig._DATA_XML_, false);

        PayStatus payStatus = convert.convert(ret);
        return payStatus;
    }

    /**
     * 接收点对点支付状况的通知
     *
     * @param payMessage
     * @return
     */
    public PayResponse accept(String payMessage, Command command) {
        NotifyStatus notifyStatus = convert.convert(payMessage);

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
    public OrderQueryResponse orderQuery(String outTradeNo) throws OrderQueryException {
        if (outTradeNo == null || "".equals(outTradeNo.trim())) {
            throw new OrderQueryException("系统订单号和微信支付流水号只能填一个");
        }

        String nonceStr = StringUtils.randomString(8);
        // 及其不优雅的代码又一次出现
        Map<String, Object> params = new HashMap<>();
        params.put("appid", WechatConfig._APP_ID_);
        params.put("mch_id", WechatConfig._WX_MCHID_);
        params.put("out_trade_no", outTradeNo);
        params.put("nonce_str", nonceStr);
        params.put("key", WechatConfig._WX_MCH_KEY_);
        String sign = StringUtils.signature(params, "MD5", true);

        OrderQueryParams orderQueryParams = new OrderQueryParams(
                WechatConfig._APP_ID_, WechatConfig._WX_MCHID_, outTradeNo, nonceStr, sign
        );
        String params_xml_format = convert.reverse(orderQueryParams);
        String ret = WebUtils.post(_ORDER_QUERY_URL_, params_xml_format, WechatConfig._DATA_XML_, false);

        return convert.convert(ret);
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
    public RefundResponse refund(String outTradeNo, String refundNo, int totalFee, int refundFee, String opUserId) {
        String nonceStr = StringUtils.randomString(8);
        Map<String, Object> params = new HashMap<>();
        params.put("appid", WechatConfig._APP_ID_);
        params.put("mch_id", WechatConfig._WX_MCHID_);
        params.put("nonce_str", nonceStr);
        params.put("out_trade_no", outTradeNo);
        params.put("out_refund_no", refundNo);
        params.put("total_fee", String.valueOf(totalFee));
        params.put("refund_fee", String.valueOf(refundFee));
        params.put("op_user_id", opUserId);
        params.put("key", WechatConfig._WX_MCH_KEY_);
        String sign = StringUtils.signature(params, "MD5", true);

        RefundParams refundParams = new RefundParams(
                WechatConfig._APP_ID_, WechatConfig._WX_MCHID_, nonceStr, sign, outTradeNo, refundNo, totalFee,
                refundFee, opUserId
        );
        String params_xml_form = convert.reverse(refundParams);
        String ret = WebUtils.post(_REFUND_URL_, params_xml_form, WechatConfig._DATA_XML_, true);

        return convert.convert(ret);
    }
}

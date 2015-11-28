/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import net.yoomai.wechat.beans.payment.NotifyStatus;
import net.yoomai.wechat.beans.payment.PayParams;
import net.yoomai.wechat.beans.payment.PayResponse;
import net.yoomai.wechat.beans.payment.PayStatus;
import net.yoomai.wechat.commands.Command;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.converts.AppConvert;
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

    private static final String _PREPAYMENT_URL_ = "";

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
        String ret = WebUtils.post(_PREPAYMENT_URL_, params_xml_format, "xml", false);

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
}

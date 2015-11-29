/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 支付提交的参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PayParams.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class PayParams {
    @XStreamAlias("appid")
    private String appId; // 公众号ID
    @XStreamAlias("mch_id")
    private String mchId; // 商户号
    @XStreamAlias("nonce_str")
    private String nonceStr; // 随机数
    @XStreamAlias("sign")
    private String sign; // 签名
    @XStreamAlias("body")
    private String body; // 商品简单描述
    @XStreamAlias("out_treade_no")
    private String outTradeNo; // 系统订单号
    @XStreamAlias("total_fee")
    private int totalFee; // 订单总金额
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp; // 客户端IP
    @XStreamAlias("notify_url")
    private String notifyURL; // 通知支付结果的地址
    @XStreamAlias("trade_type")
    private String tradeType; // JSAPI
    @XStreamAlias("openid")
    private String openId; // 用户标识

    public PayParams(String appId, String mchId, String nonceStr, String sign, String body,
                     String outTradeNo, int totalFee, String spbillCreateIp, String notifyURL,
                     String tradeType, String openId) {
        this.appId = appId;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.body = body;
        this.outTradeNo = outTradeNo;
        this.totalFee = totalFee;
        this.spbillCreateIp = spbillCreateIp;
        this.notifyURL = notifyURL;
        this.tradeType = tradeType;
        this.openId = openId;
    }

    public String getAppId() {
        return appId;
    }

    public String getMchId() {
        return mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public String getBody() {
        return body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public String getNotifyURL() {
        return notifyURL;
    }

    public String getTradeType() {
        return tradeType;
    }

    public String getOpenId() {
        return openId;
    }
}

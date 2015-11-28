/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 支付提交的参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PayParams.java 1.0 28/11/2015
 */
public class PayParams {
    private String appId; // 公众号ID
    private String mchId; // 商户号
    private String nonceStr; // 随机数
    private String sign; // 签名
    private String body; // 商品简单描述
    private String outTradeNo; // 系统订单号
    private int totalFee; // 订单总金额
    private String spbillCreateIp; // 客户端IP
    private String notifyURL; // 通知支付结果的地址
    private String tradeType; // JSAPI

    public PayParams(String appId, String mchId, String nonceStr, String sign, String body, String outTradeNo, int totalFee, String spbillCreateIp, String notifyURL, String tradeType) {
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
}

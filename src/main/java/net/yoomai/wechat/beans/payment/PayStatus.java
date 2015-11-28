/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 支付状态，非异步通知结果
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PayStatus.java 1.0 28/11/2015
 */
public class PayStatus {
    private String returnCode;
    private String returnMsg;
    private String appId;
    private String mchId;
    private String nonceStr; //微信返回的随机字符串
    private String sign; // 微信返回的签名
    private String resultCode; // SUCCESS/FAIL
    private String prepayId; // 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
    private String tradeType;

    public PayStatus(String returnCode, String returnMsg, String appId, String mchId, String nonceStr, String sign, String resultCode, String prepayId, String tradeType) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.appId = appId;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.resultCode = resultCode;
        this.prepayId = prepayId;
        this.tradeType = tradeType;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
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

    public String getResultCode() {
        return resultCode;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public String getTradeType() {
        return tradeType;
    }
}

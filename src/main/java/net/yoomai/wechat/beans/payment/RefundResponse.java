/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 申请退款的响应信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)RefundResponse.java 1.0 28/11/2015
 */
public class RefundResponse {
    private String returnCode;
    private String returnMsg;
    private String resultCode;
    private String appId;
    private String mchId;
    private String nonceStr;
    private String sign;
    private String transactionId;
    private String outTradeNo;
    private String outRefundNo;
    private String refundId;
    private int refundFee;
    private int totalFee;
    private int cashFee;

    public RefundResponse(String returnCode, String returnMsg, String resultCode, String appId, String mchId,
                          String nonceStr, String sign, String transactionId, String outTradeNo, String outRefundNo,
                          String refundId, int refundFee, int totalFee, int cashFee) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.resultCode = resultCode;
        this.appId = appId;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
        this.outRefundNo = outRefundNo;
        this.refundId = refundId;
        this.refundFee = refundFee;
        this.totalFee = totalFee;
        this.cashFee = cashFee;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public String getResultCode() {
        return resultCode;
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

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public int getCashFee() {
        return cashFee;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 订单查询结果的响应信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)OrderQueryResponse.java 1.0 28/11/2015
 */
public class OrderQueryResponse {
    private String returnCode;
    private String returnMsg;
    private String appId;
    private String mchId;
    private String nonceStr;
    private String sign;
    private String resultCode;
    private String openId;
    private String tradeType;
    private String tradeState;
    private String bankType;
    private int totalFee;
    private int cashFee;
    private String transactionId;
    private String outTradeNo;
    private String timeEnd;
    private String tradeStateDesc;

    public OrderQueryResponse(String returnCode, String returnMsg, String appId, String mchId, String nonceStr,
                              String sign, String resultCode, String openId, String tradeType, String tradeState,
                              String bankType, int totalFee, int cashFee, String transactionId, String outTradeNo,
                              String timeEnd, String tradeStateDesc) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.appId = appId;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.resultCode = resultCode;
        this.openId = openId;
        this.tradeType = tradeType;
        this.tradeState = tradeState;
        this.bankType = bankType;
        this.totalFee = totalFee;
        this.cashFee = cashFee;
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
        this.timeEnd = timeEnd;
        this.tradeStateDesc = tradeStateDesc;
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

    public String getOpenId() {
        return openId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public int getCashFee() {
        return cashFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }
}

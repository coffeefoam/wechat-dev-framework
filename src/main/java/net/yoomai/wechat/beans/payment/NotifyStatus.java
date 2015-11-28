/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 支付后，微信后台异步通知结果
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)NotifyStatus.java 1.0 28/11/2015
 */
public class NotifyStatus extends PayStatus {    // 以下是接收支付通知时使用
    private String openid;
    private String isSubscribe; // 是否订阅
    private String bankType;
    private int totalFee;
    private int cashFee;
    private String transactionId;
    private String outTradeNo;
    private String timeEnd;
    private String feeType;

    public NotifyStatus(String returnCode, String returnMsg, String appId, String mchId, String nonceStr, String sign,
                        String resultCode, String prepayId, String tradeType, String openid, String isSubscribe,
                        String bankType, int totalFee, int cashFee, String transactionId, String outTradeNo,
                        String timeEnd, String feeType) {
        super(returnCode, returnMsg, appId, mchId, nonceStr, sign, resultCode, prepayId, tradeType);
        this.openid = openid;
        this.isSubscribe = isSubscribe;
        this.bankType = bankType;
        this.totalFee = totalFee;
        this.cashFee = cashFee;
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
        this.timeEnd = timeEnd;
        this.feeType = feeType;
    }

    public String getOpenid() {
        return openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
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

    public String getFeeType() {
        return feeType;
    }
}

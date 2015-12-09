/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 支付后，微信后台异步通知结果
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)NotifyStatus.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class NotifyStatus {    // 以下是接收支付通知时使用
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("appid")
    private String appId;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("nonce_str")
    private String nonceStr; //微信返回的随机字符串
    @XStreamAlias("sign")
    private String sign; // 微信返回的签名
    @XStreamAlias("result_code")
    private String resultCode; // SUCCESS/FAIL
    @XStreamAlias("prepay_id")
    private String prepayId; // 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
    @XStreamAlias("trade_type")
    private String tradeType;
    @XStreamAlias("openid")
    private String openid;
    @XStreamAlias("is_subscribe")
    private String isSubscribe; // 是否订阅
    @XStreamAlias("bank_type")
    private String bankType;
    @XStreamAlias("total_fee")
    private int totalFee;
    @XStreamAlias("cash_fee")
    private int cashFee;
    @XStreamAlias("transaction_id")
    private String transactionId;
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    @XStreamAlias("time_end")
    private String timeEnd;
    @XStreamAlias("fee_type")
    private String feeType;

    public NotifyStatus() {}

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getCashFee() {
        return cashFee;
    }

    public void setCashFee(int cashFee) {
        this.cashFee = cashFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
}

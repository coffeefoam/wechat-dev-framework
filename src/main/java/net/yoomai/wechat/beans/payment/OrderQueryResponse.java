/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订单查询结果的响应信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)OrderQueryResponse.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class OrderQueryResponse {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("appid")
    private String appId;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("openid")
    private String openId;
    @XStreamAlias("is_subscribe")
    private String isSubscribe;
    @XStreamAlias("trade_type")
    private String tradeType;
    @XStreamAlias("trade_state")
    private String tradeState;
    @XStreamAlias("bank_type")
    private String bankType;
    @XStreamAlias("total_fee")
    private int totalFee;
    @XStreamAlias("fee_type")
    private String feeType;
    @XStreamAlias("cash_fee")
    private int cashFee;
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    @XStreamAlias("coupon_fee")
    private int couponFee;
    @XStreamAlias("coupon_count")
    private int couponCount;
    @XStreamAlias("transaction_id")
    private String transactionId;
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    @XStreamAlias("attach")
    private String attach;
    @XStreamAlias("time_end")
    private String timeEnd;
    @XStreamAlias("trade_state_desc")
    private String tradeStateDesc;
    @XStreamAlias("error_code")
    private String errorCode;

    public OrderQueryResponse() {}

    public OrderQueryResponse(String returnCode, String returnMsg, String appId, String mchId, String nonceStr, String sign, String resultCode, String openId, String isSubscribe, String tradeType, String tradeState, String bankType, int totalFee, String feeType, int cashFee, String cashFeeType, int couponFee, int couponCount, String transactionId, String outTradeNo, String attach, String timeEnd, String tradeStateDesc, String errorCode) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.appId = appId;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.resultCode = resultCode;
        this.openId = openId;
        this.isSubscribe = isSubscribe;
        this.tradeType = tradeType;
        this.tradeState = tradeState;
        this.bankType = bankType;
        this.totalFee = totalFee;
        this.feeType = feeType;
        this.cashFee = cashFee;
        this.cashFeeType = cashFeeType;
        this.couponFee = couponFee;
        this.couponCount = couponCount;
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
        this.attach = attach;
        this.timeEnd = timeEnd;
        this.tradeStateDesc = tradeStateDesc;
        this.errorCode = errorCode;
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

    public String getIsSubscribe() {
        return isSubscribe;
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

    public String getFeeType() {
        return feeType;
    }

    public int getCashFee() {
        return cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public int getCouponFee() {
        return couponFee;
    }

    public int getCouponCount() {
        return couponCount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

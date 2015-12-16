/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 申请退款的响应信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)RefundResponse.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class RefundResponse {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("appid")
    private String appId;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("transaction_id")
    private String transactionId;
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    @XStreamAlias("out_refund_no")
    private String outRefundNo;
    @XStreamAlias("refund_id")
    private String refundId;
    @XStreamAlias("refund_channel")
    private String refundChannel;
    @XStreamAlias("refund_fee")
    private int refundFee;
    @XStreamAlias("total_fee")
    private int totalFee;
    @XStreamAlias("fee_type")
    private String feeType;
    @XStreamAlias("cash_fee")
    private int cashFee;
    @XStreamAlias("cash_refund_fee")
    private int cashRefundFee;
    @XStreamAlias("coupon_refund_fee")
    private int couponRefundFee;
    @XStreamAlias("coupon_refund_count")
    private int couponRefundCount;
    @XStreamAlias("coupon_refund_id")
    private String couponRefundId;

    public RefundResponse() {}

    public RefundResponse(String returnCode, String returnMsg, String resultCode, String appId, String mchId,
                          String nonceStr, String sign, String transactionId, String outTradeNo, String outRefundNo,
                          String refundId, String refundChannel, int refundFee, int totalFee, String feeType,
                          int cashFee, int cashRefundFee, int couponRefundFee, int couponRefundCount, String couponRefundId) {
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
        this.refundChannel = refundChannel;
        this.refundFee = refundFee;
        this.totalFee = totalFee;
        this.feeType = feeType;
        this.cashFee = cashFee;
        this.cashRefundFee = cashRefundFee;
        this.couponRefundFee = couponRefundFee;
        this.couponRefundCount = couponRefundCount;
        this.couponRefundId = couponRefundId;
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

    public String getRefundChannel() {
        return refundChannel;
    }

    public int getRefundFee() {
        return refundFee;
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

    public int getCashRefundFee() {
        return cashRefundFee;
    }

    public int getCouponRefundFee() {
        return couponRefundFee;
    }

    public int getCouponRefundCount() {
        return couponRefundCount;
    }

    public String getCouponRefundId() {
        return couponRefundId;
    }
}

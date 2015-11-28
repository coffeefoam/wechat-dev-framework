/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 退款申请的参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)RefundParams.java 1.0 28/11/2015
 */
public class RefundParams {
    private String appId;
    private String mchId;
    private String nonceStr;
    private String sign;
    private String outTradeNo;
    private String outRefundNo;
    private int totalFee;
    private int refundFee;
    private String opUserId;

    public RefundParams(String appId, String mchId, String nonceStr, String sign, String outTradeNo, String outRefundNo, int totalFee, int refundFee, String opUserId) {
        this.appId = appId;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.outTradeNo = outTradeNo;
        this.outRefundNo = outRefundNo;
        this.totalFee = totalFee;
        this.refundFee = refundFee;
        this.opUserId = opUserId;
    }
}

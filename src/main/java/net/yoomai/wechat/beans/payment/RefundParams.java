/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 退款申请的参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)RefundParams.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class RefundParams {
    @XStreamAlias("appid")
    private String appId;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    @XStreamAlias("out_refund_no")
    private String outRefundNo;
    @XStreamAlias("total_fee")
    private int totalFee;
    @XStreamAlias("refund_fee")
    private int refundFee;
    @XStreamAlias("op_user_id")
    private String opUserId;

    public RefundParams() {}

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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public String getOpUserId() {
        return opUserId;
    }
}

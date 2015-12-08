/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订单查询参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)OrderQueryParams.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class OrderQueryParams {
    @XStreamAlias("appid")
    private String appId;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("sign")
    private String sign;

    public OrderQueryParams() {}

    public OrderQueryParams(String appId, String mchId, String outTradeNo, String nonceStr, String sign) {
        this.appId = appId;
        this.mchId = mchId;
        this.outTradeNo = outTradeNo;
        this.nonceStr = nonceStr;
        this.sign = sign;
    }

    public String getAppId() {
        return appId;
    }

    public String getMchId() {
        return mchId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }
}

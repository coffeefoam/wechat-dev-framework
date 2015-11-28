/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

/**
 * 订单查询参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)OrderQueryParams.java 1.0 28/11/2015
 */
public class OrderQueryParams {
    private String appId;
    private String mchId;
    private String outTradeNo;
    private String nonceStr;
    private String sign;

    public OrderQueryParams(String appId, String mchId, String outTradeNo, String nonceStr, String sign) {
        this.appId = appId;
        this.mchId = mchId;
        this.outTradeNo = outTradeNo;
        this.nonceStr = nonceStr;
        this.sign = sign;
    }
}

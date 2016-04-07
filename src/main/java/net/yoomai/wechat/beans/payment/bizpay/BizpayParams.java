/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment.bizpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 接收扫码支付回调的参数信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)BizpayParams.java 1.0 07/04/2016
 */
@XStreamAlias("xml")
public class BizpayParams {
    @XStreamAlias("appid")
    private String appid;
    @XStreamAlias("openid")
    private String openid;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("is_subscribe")
    private String isSubscribe;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("product_id")
    private String productId;
    @XStreamAlias("sign")
    private String sign;

    public BizpayParams() {
    }

    public BizpayParams(String appid, String openid, String mchId, String isSubscribe, String nonceStr, String productId, String sign) {
        this.appid = appid;
        this.openid = openid;
        this.mchId = mchId;
        this.isSubscribe = isSubscribe;
        this.nonceStr = nonceStr;
        this.productId = productId;
        this.sign = sign;
    }

    public String getAppid() {
        return appid;
    }

    public String getOpenid() {
        return openid;
    }

    public String getMchId() {
        return mchId;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getProductId() {
        return productId;
    }

    public String getSign() {
        return sign;
    }
}

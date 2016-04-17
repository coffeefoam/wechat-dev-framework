/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业支付查询请求参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TransferQueryParams.java 1.0 17/04/2016
 */
@XStreamAlias("xml")
public class TransferQueryParams {
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("partner_trade_no")
    private String tradeNo;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("appid")
    private String appid;

    public TransferQueryParams() {
    }

    public TransferQueryParams(String nonceStr, String sign, String tradeNo, String mchId, String appid) {
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.tradeNo = tradeNo;
        this.mchId = mchId;
        this.appid = appid;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public String getMchId() {
        return mchId;
    }

    public String getAppid() {
        return appid;
    }
}

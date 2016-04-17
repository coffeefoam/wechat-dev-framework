/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款请求参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TransferParams.java 1.0 17/04/2016
 */
@XStreamAlias("xml")
public class TransferParams {
    @XStreamAlias("mch_appid")
    private String appid;
    @XStreamAlias("mchid")
    private String mchId;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("sign")
    private String sign;
    @XStreamAlias("partner_trade_no")
    private String tradeNo;
    @XStreamAlias("openid")
    private String openid;
    @XStreamAlias("check_name")
    private String checkName;
    @XStreamAlias("amount")
    private int amount;
    @XStreamAlias("desc")
    private String desc;
    @XStreamAlias("spbill_create_ip")
    private String ip;

    public TransferParams() {
    }

    public TransferParams(String appid, String mchId, String nonceStr, String sign, String tradeNo, String openid, String checkName,
                          int amount, String desc, String ip) {
        this.appid = appid;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.tradeNo = tradeNo;
        this.openid = openid;
        this.checkName = checkName;
        this.amount = amount;
        this.desc = desc;
        this.ip = ip;
    }

    public String getAppid() {
        return appid;
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

    public String getTradeNo() {
        return tradeNo;
    }

    public String getOpenid() {
        return openid;
    }

    public String getCheckName() {
        return checkName;
    }

    public int getAmount() {
        return amount;
    }

    public String getDesc() {
        return desc;
    }

    public String getIp() {
        return ip;
    }
}

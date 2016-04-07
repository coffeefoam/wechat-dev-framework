/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment.bizpay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 回应微信服务扫码支付的相应,其中包括预支付单的订单号
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)BizpayResponse.java 1.0 07/04/2016
 */
@XStreamAlias("xml")
public class BizpayResponse {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("appid")
    private String appid;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("prepay_id")
    private String prepayId;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("err_code_des")
    private String errCodeDes;
    @XStreamAlias("sign")
    private String sign;

    public BizpayResponse() {
    }

    public BizpayResponse(String returnCode, String returnMsg, String appid, String mchId, String nonceStr, String prepayId, String resultCode,
                          String errCodeDes, String sign) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.appid = appid;
        this.mchId = mchId;
        this.nonceStr = nonceStr;
        this.prepayId = prepayId;
        this.resultCode = resultCode;
        this.errCodeDes = errCodeDes;
        this.sign = sign;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
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

    public String getPrepayId() {
        return prepayId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public String getSign() {
        return sign;
    }
}

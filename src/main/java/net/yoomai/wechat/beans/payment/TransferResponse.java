/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款的响应体
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TransferResponse.java 1.0 17/04/2016
 */
@XStreamAlias("xml")
public class TransferResponse {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("mch_appid")
    private String appid;
    @XStreamAlias("mchid")
    private String mchId;
    @XStreamAlias("device_info")
    private String deviceInfo;
    @XStreamAlias("nonce_str")
    private String nonceStr;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("err_code")
    private String errorCode;
    @XStreamAlias("err_code_des")
    private String errorDesc;
    @XStreamAlias("partner_trade_no")
    private String tradeNo;
    @XStreamAlias("payment_no")
    private String paymentNo;
    @XStreamAlias("payment_time")
    private String paymentTime;

    public TransferResponse() {
    }

    public TransferResponse(String returnCode, String returnMsg, String appid, String mchId, String deviceInfo, String nonceStr, String resultCode,
                            String errorCode, String errorDesc, String tradeNo, String paymentNo, String paymentTime) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.appid = appid;
        this.mchId = mchId;
        this.deviceInfo = deviceInfo;
        this.nonceStr = nonceStr;
        this.resultCode = resultCode;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.tradeNo = tradeNo;
        this.paymentNo = paymentNo;
        this.paymentTime = paymentTime;
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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }
}

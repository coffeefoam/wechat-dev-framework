/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业付款查询响应
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TransferQueryResponse.java 1.0 17/04/2016
 */
@XStreamAlias("xml")
public class TransferQueryResponse {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;
    @XStreamAlias("result_code")
    private String resultCode;
    @XStreamAlias("err_code")
    private String errCode;
    @XStreamAlias("err_code_des")
    private String errDesc;
    @XStreamAlias("partner_trade_no")
    private String tradeNo;
    @XStreamAlias("mch_id")
    private String mchId;
    @XStreamAlias("detail_id")
    private String detailId;
    @XStreamAlias("status")
    private String status;
    @XStreamAlias("reason")
    private String reason;
    @XStreamAlias("openid")
    private String openid;
    @XStreamAlias("transfer_name")
    private String transferName;
    @XStreamAlias("payment_amount")
    private int amount;
    @XStreamAlias("transfer_time")
    private String transferTime;
    @XStreamAlias("desc")
    private String desc;

    public TransferQueryResponse() {
    }

    public TransferQueryResponse(String returnCode, String returnMsg, String resultCode, String errCode, String errDesc, String tradeNo,
                                 String mchId, String detailId, String status, String reason, String openid, String transferName, int amount,
                                 String transferTime, String desc) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.resultCode = resultCode;
        this.errCode = errCode;
        this.errDesc = errDesc;
        this.tradeNo = tradeNo;
        this.mchId = mchId;
        this.detailId = detailId;
        this.status = status;
        this.reason = reason;
        this.openid = openid;
        this.transferName = transferName;
        this.amount = amount;
        this.transferTime = transferTime;
        this.desc = desc;
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

    public String getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public String getMchId() {
        return mchId;
    }

    public String getDetailId() {
        return detailId;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public String getOpenid() {
        return openid;
    }

    public String getTransferName() {
        return transferName;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public String getDesc() {
        return desc;
    }
}

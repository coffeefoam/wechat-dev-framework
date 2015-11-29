/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.payment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 支付成功后，服务器接到点对点通知，需要回给支付平台信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PayResponse.java 1.0 28/11/2015
 */
@XStreamAlias("xml")
public class PayResponse {
    @XStreamAlias("return_code")
    private String returnCode;
    @XStreamAlias("return_msg")
    private String returnMsg;

    public PayResponse(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }
}

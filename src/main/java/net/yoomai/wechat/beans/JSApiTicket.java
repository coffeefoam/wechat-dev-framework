/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans;

/**
 * 用于获取JSAPI ticket票据信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)JSApiTicket.java 1.0 27/11/2015
 */
public class JSApiTicket {
    private int errcode;
    private String errmsg;
    private String ticket;
    private int expiresIn;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}

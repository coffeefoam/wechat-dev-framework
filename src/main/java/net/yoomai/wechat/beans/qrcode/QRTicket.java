/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.qrcode;

/**
 * 用于解析二维码生成后返回的ticket
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)QRTicket.java 1.0 31/03/2016
 */
public class QRTicket {
    private String ticket;
    private String expire_seconds;
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

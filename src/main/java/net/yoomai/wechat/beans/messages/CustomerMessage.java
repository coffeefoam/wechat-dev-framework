/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * 发送客服消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)CustomerMessage.java 1.0 28/11/2015
 */
public class CustomerMessage implements Message {
    private String touser;
    private String msgtype;

    public CustomerMessage(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import java.util.Map;

/**
 * 客服文本消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)CustomerTextMessage.java 1.0 28/11/2015
 */
public class CustomTextMessage extends CustomMessage {
    private String touser;
    private Map text;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public Map getText() {
        return text;
    }

    public void setText(Map text) {
        this.text = text;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import java.util.Map;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)CustomerTextMessage.java 1.0 28/11/2015
 */
public class CustomerTextMessage extends CustomerMessage {
    private Map text;

    public CustomerTextMessage(String touser, Map text) {
        super(touser, TEXT);
        this.text = text;
    }

    public Map getText() {
        return text;
    }

    public void setText(Map text) {
        this.text = text;
    }
}

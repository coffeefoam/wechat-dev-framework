/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 可接收的文本消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TextMessage.java 1.0 30/11/2015
 */
@XStreamAlias("xml")
public class TextMessage extends Message {
    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

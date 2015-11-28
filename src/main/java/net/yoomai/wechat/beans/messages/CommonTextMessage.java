/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TextMessage.java 1.0 28/11/2015
 */
public class CommonTextMessage extends CommonMessage{
    private String content;

    public CommonTextMessage(String toUserName, String fromUserName, long createTime, long msgId, String content) {
        super(toUserName, fromUserName, createTime, TEXT, msgId);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

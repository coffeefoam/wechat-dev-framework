/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * 文本消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TextMessage.java 1.0 27/11/2015
 */
public class TextMessage extends Message{
    private String content;

    /**
     *
     * @param msgId
     * @param toUserName
     * @param fromUserName
     * @param createTime
     * @param content
     */
    public TextMessage(long msgId, String toUserName, String fromUserName, long createTime, String content) {
        super(msgId, toUserName, fromUserName, createTime);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

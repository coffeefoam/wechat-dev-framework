/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * 基础消息信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)BaseMessage.java 1.0 27/11/2015
 */
public class Message extends MsgType{
    private long msgId;
    private String toUserName;
    private String fromUserName;
    private long createTime;

    public Message(long msgId, String toUserName, String fromUserName, long createTime) {
        this.msgId = msgId;
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}

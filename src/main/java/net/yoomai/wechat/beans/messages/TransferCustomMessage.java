/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 客服消息转发
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TransferMessage.java 1.0 09/04/2016
 */
@XStreamAlias("xml")
public class TransferCustomMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public TransferCustomMessage() {
    }

    public TransferCustomMessage(String toUserName, String fromUserName, long createTime, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getMsgType() {
        return msgType;
    }
}

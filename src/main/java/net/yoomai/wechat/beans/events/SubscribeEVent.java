/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订阅或取消订阅的事件信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)SubscribeEVent.java 1.0 04/04/2016
 */
@XStreamAlias("xml")
public class SubscribeEVent {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Event")
    private String event;

    public SubscribeEVent() {
    }

    public SubscribeEVent(String toUserName, String fromUserName, long createTime, String msgType, String event) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.event = event;
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

    public String getEvent() {
        return event;
    }
}

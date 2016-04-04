/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 扫描带参数二维码事件
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)QRsceneEvent.java 1.0 04/04/2016
 */
@XStreamAlias("xml")
public class QRsceneEvent {
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
    @XStreamAlias("EventKey")
    private String eventKey;
    @XStreamAlias("Ticket")
    private String ticket;

    public QRsceneEvent() {
    }

    public QRsceneEvent(String toUserName, String fromUserName, long createTime, String msgType, String event, String eventKey, String ticket) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.event = event;
        this.eventKey = eventKey;
        this.ticket = ticket;
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

    public String getEventKey() {
        return eventKey;
    }

    public String getTicket() {
        return ticket;
    }
}

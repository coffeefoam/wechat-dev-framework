/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.events;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)Event.java 1.0 30/11/2015
 */
@XStreamAlias("xml")
public class Event {
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
    @XStreamAlias("Latitude")
    private float latitude;
    @XStreamAlias("Longitude")
    private float longitude;
    @XStreamAlias("Precision")
    private float precision;

    /**
     * 订阅
     */
    public static final String SUBSCRIBE_EVENT = "subscribe";

    /**
     * 取消订阅
     */
    public static final String UNSUBSCRIBE_EVENT = "unsubscribe";

    /**
     * 扫描带参数二维码事件（用户已关注时）
     */
    public static final String SCAN_EVENT = "SCAN";

    /**
     * 上报地理位置事件
     */
    public static final String LOCATION_EVENT = "LOCATION";

    /**
     * 点击菜单拉取消息事件
     */
    public static final String CLICK_EVENT = "CLICK";

    /**
     * 点击菜单跳转链接事件
     */
    public static final String VIEW_EVENT = "VIEW";

    public Event() {
    }

    public Event(String toUserName, String fromUserName, long createTime, String msgType, String event, String eventKey, String ticket,
                 float latitude, float longitude, float precision) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.event = event;
        this.eventKey = eventKey;
        this.ticket = ticket;
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
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

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getPrecision() {
        return precision;
    }
}

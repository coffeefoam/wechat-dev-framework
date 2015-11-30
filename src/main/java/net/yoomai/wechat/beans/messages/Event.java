/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

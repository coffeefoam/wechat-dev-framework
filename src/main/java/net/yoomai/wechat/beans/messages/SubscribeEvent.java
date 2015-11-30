/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 订阅的事件通知
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)SubscribeEvent.java 1.0 30/11/2015
 */
public class SubscribeEvent extends Event {
    @XStreamAlias("EventKey")
    private String eventKey;
    @XStreamAlias("Ticket")
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.commands;

import net.yoomai.wechat.beans.messages.Message;

/**
 * 各种命令处理动作
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)Command.java 1.0 27/11/2015
 */
public interface Command {
    /**
     * 接受微信推送的消息，并进行处理，同时返回相关结果消息
     *
     * @param receiveMessage
     * @return 返回各类消息
     */
    public Message processMessage(Message receiveMessage);

    /**
     * 接受微信推送的事件并处理，处理后返回相应消息
     *
     * @param receiveEvent
     * @return
     */
    public Message processEvent(Message receiveEvent);
}

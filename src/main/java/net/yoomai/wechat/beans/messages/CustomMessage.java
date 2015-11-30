/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * 客服消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)CustomerMessage.java 1.0 28/11/2015
 */
public class CustomMessage {
    private String msgtype;

    /**
     * 文本消息
     */
    public static final String TEXT = "text";

    /**
     * 图片消息
     */
    public static final String IMAGE = "image";

    /**
     * 语音消息
     */
    public static final String VOICE = "voice";

    /**
     * 视频消息
     */
    public static final String VIDEO = "video";

    /**
     * 音乐消息
     */
    public static final String MUSIC = "music";

    /**
     * 图文消息, 跳转到链接
     */
    public static final String NEWS = "news";

    /**
     * 图文消息, 跳转到图文消息页
     */
    public static final String MPNEWS = "mpnews";

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}

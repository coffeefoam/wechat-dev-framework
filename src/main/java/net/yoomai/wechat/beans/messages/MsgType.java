/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * 微信中的消息类型
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)MsgType.java 1.0 27/11/2015
 */
public class MsgType {
    private String mstType;

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
     * 短视频消息
     */
    public static final String SHORTVIDEO = "shortvideo";

    /**
     * 地理位置信息
     */
    public static final String LOCATION = "location";

    /**
     * 链接信息
     */
    public static final String LINK = "link";

    public String getMstType() {
        return mstType;
    }

    public void setMstType(String mstType) {
        this.mstType = mstType;
    }
}

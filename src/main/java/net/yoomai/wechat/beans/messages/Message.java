/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 消息基础模块
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)Message.java 1.0 28/11/2015
 */
public class Message {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("MsgId")
    private long msgId;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("Format")
    private String format;
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
    @XStreamAlias("Location_X")
    private float locationX;
    @XStreamAlias("Location_Y")
    private float locationY;
    @XStreamAlias("Scale")
    private float scale;
    @XStreamAlias("Label")
    private String label;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("Url")
    private String url;


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
     * 位置消息
     */
    public static final String LOCATION = "location";

    /**
     * 链接消息
     */
    public static final String LINK = "link";

    /**
     * 图文消息
     */
    public static final String NEWS = "news";

    /**
     * 事件
     */
    public static final String EVENT = "event";

    public Message() {
    }

    public Message(String toUserName, String fromUserName, long createTime, String msgType, long msgId, String picUrl, String mediaId,
                   String format, String thumbMediaId, float locationX, float locationY, float scale, String label, String title,
                   String description, String url) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.msgType = msgType;
        this.msgId = msgId;
        this.picUrl = picUrl;
        this.mediaId = mediaId;
        this.format = format;
        this.thumbMediaId = thumbMediaId;
        this.locationX = locationX;
        this.locationY = locationY;
        this.scale = scale;
        this.label = label;
        this.title = title;
        this.description = description;
        this.url = url;
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

    public long getMsgId() {
        return msgId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getFormat() {
        return format;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public float getLocationX() {
        return locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public float getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

/**
 * 普通的图片消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)ImageMessage.java 1.0 28/11/2015
 */
public class CommonImageMessage extends CommonMessage {
    private String picUrl;
    private String mediaId;

    public CommonImageMessage(String toUserName, String fromUserName, long createTime, long msgId, String picUrl, String mediaId) {
        super(toUserName, fromUserName, createTime, IMAGE, msgId);
        this.picUrl = picUrl;
        this.mediaId = mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import com.google.gson.Gson;
import net.yoomai.wechat.beans.events.Event;
import net.yoomai.wechat.beans.messages.CustomMessage;
import net.yoomai.wechat.beans.messages.Message;
import net.yoomai.wechat.beans.messages.TemplateMessage;
import net.yoomai.wechat.commands.Command;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.utils.WebUtils;

/**
 * 发送消息的能力
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)MessageCapability.java 1.0 27/11/2015
 */
public class MessageCapability extends AbstractCapability{
    /**
     * 客服消息发送地址
     */
    private static final String _CUSTOMER_SEND_ = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

    /**
     * 模板消息发送地址
     */
    private static final String _TEMPLATE_SEND_ = "https://api.weixin.qq.com/cgi-bin/message/template/send";

    /**
     * 发送客服消息
     *
     * @param customerMessage
     * @param accessToken
     */
    public void sendCustomMessage(CustomMessage cmessage, String accessToken) {
        Gson gson = new Gson();
        String message = gson.toJson(cmessage);

        String url = _CUSTOMER_SEND_ + "?access_token=" + accessToken;
        WebUtils.post(url, message, WechatConfig._DATA_JSON_, false, null);
    }

    /**
     * 发送模板消息
     *
     * @param templateMessage
     */
    public void sendTemplateMessage(TemplateMessage templateMessage) {
        Gson gson = new Gson();
        String message = gson.toJson(templateMessage);

        WebUtils.post(_TEMPLATE_SEND_, message, WechatConfig._DATA_JSON_, false, null);
    }
}

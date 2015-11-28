/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.messages;

import java.util.Map;

/**
 * 模板消息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)TemplateMessage.java 1.0 28/11/2015
 */
public class TemplateMessage implements Message {
    private String touser;
    private String template_id;
    private String url;
    private Map data;

    public TemplateMessage(String touser, String template_id, String url, Map data) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.data = data;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans;

/**
 * 微信全局访问令牌
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)GlobalAccessToken.java 1.0 27/11/2015
 */
public class GlobalAccessToken {
    private String access_token;
    private int expires;

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}

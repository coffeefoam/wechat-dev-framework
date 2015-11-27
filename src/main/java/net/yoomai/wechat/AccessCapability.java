/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat;

import com.google.gson.Gson;
import net.yoomai.wechat.beans.GlobalAccessToken;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.utils.WebUtils;

/**
 * 提供微信访问的能力，获得accesstoken等一系列的参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AccessCapability.java 1.0 27/11/2015
 */
public class AccessCapability {
    private static final String _ACCESS_TOKEN_URL_ = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 获得具有中控访问能力的access令牌
     *
     * @return
     */
    public GlobalAccessToken getAccessToken() {
        String url = _ACCESS_TOKEN_URL_ + "?grant_type=client_credential&appid=" + WechatConfig._APP_ID_ + "&secret="
                + WechatConfig._APP_SECRET_;
        String accessToken = WebUtils.get(url);
        GlobalAccessToken globalAccessToken = null;

        if (accessToken != null) {
            Gson gson = new Gson();
            globalAccessToken = gson.fromJson(accessToken, GlobalAccessToken.class);
        }

        return globalAccessToken;
    }
}

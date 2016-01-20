/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import com.google.gson.Gson;
import net.yoomai.wechat.beans.GlobalAccessToken;
import net.yoomai.wechat.beans.JSApiTicket;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.utils.StringUtils;
import net.yoomai.wechat.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供微信访问的能力，获得accesstoken等一系列的参数
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AccessCapability.java 1.0 27/11/2015
 */
public class AccessCapability extends AbstractCapability {
    private static final String _ACCESS_TOKEN_URL_ = "https://api.weixin.qq.com/cgi-bin/token";

    private static final String _JSAPI_TICKET_URL_ = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

    public AccessCapability(String id) {
        init(id);
    }

    /**
     * 获得具有中控访问能力的access令牌
     *
     * @return
     */
    public GlobalAccessToken getAccessToken() {
        String url = _ACCESS_TOKEN_URL_ + "?grant_type=client_credential&appid=" + this.appid + "&secret="
                + this.appSecret;
        String accessToken = WebUtils.get(url);
        GlobalAccessToken globalAccessToken = null;

        if (accessToken != null) {
            Gson gson = new Gson();
            globalAccessToken = gson.fromJson(accessToken, GlobalAccessToken.class);
        }

        return globalAccessToken;
    }

    /**
     * 获取js api票据信息
     *
     * @param globalAccessToken
     * @return
     */
    public JSApiTicket getJSTicket(GlobalAccessToken globalAccessToken) {
        String accessToken = globalAccessToken.getAccess_token();
        String url = _JSAPI_TICKET_URL_ + "?access_token=" + accessToken + "&type=jsapi";
        String result = WebUtils.get(url);

        JSApiTicket jsApiTicket = null;
        if (result != null) {
            Gson gson = new Gson();
            jsApiTicket = gson.fromJson(result, JSApiTicket.class);
        }

        return jsApiTicket;
    }

    /**
     * 针对jsapi，计算其所需要的加密串
     *
     * @param nonceStr
     * @param timestamp
     * @param url
     * @param jsTicket
     * @return
     */
    public String signature(String nonceStr, long timestamp, String url, String jsTicket) {
        Map<String, String> params = new HashMap<>();
        params.put("jsapi_ticket", jsTicket);
        params.put("noncestr", nonceStr);
        params.put("timestamp", String.valueOf(timestamp));
        params.put("url", url);

        return StringUtils.signature(params, "SHA1", false);
    }
}

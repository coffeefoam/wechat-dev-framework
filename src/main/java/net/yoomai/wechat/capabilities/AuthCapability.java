/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import com.google.gson.Gson;
import net.yoomai.wechat.beans.AccessToken;
import net.yoomai.wechat.beans.UserInfo;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.utils.StringUtils;
import net.yoomai.wechat.utils.WebUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户授权能力
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AuthCapability.java 1.0 27/11/2015
 */
public class AuthCapability extends AbstractCapability {
    /**
     * 用户授权地址
     */
    private static final String _USER_AUTH_URL_ = "https://open.weixin.qq.com/connect/oauth2/authorize";

    /**
     * 用户获得访问令牌地址
     */
    private static final String _ACCESS_URL_ = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * 获取用户基础信息地址
     */
    private static final String _USER_INFO_URL_ = "http://api.weixin.qq.com/sns/userinfo";

    public AuthCapability(String id) {
        init(id);
    }

    /**
     * 获得用户认证的地址
     *
     * @param redirectURL
     * @return
     */
    public String getOAuthURL(String redirectURL) throws UnsupportedEncodingException {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("appid", this.appid);
        parameters.put("redirect_uri", URLEncoder.encode(redirectURL, "utf-8"));
        parameters.put("response_type", "code");
        parameters.put("scope", "snsapi_userinfo");
        parameters.put("state", StringUtils.randomString(8));

        return _USER_AUTH_URL_ + "?" + StringUtils.generateQueryString(parameters, false) + "#wechat_redirect";
    }

    /**
     * 获取用户授权后的访问票据
     *
     * @param code
     * @return
     */
    public AccessToken getAccessToken(String code) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("appid", this.appid);
        parameters.put("secret", this.appSecret);
        parameters.put("code", code);
        parameters.put("grant_type", "authorization_code");

        String url = _ACCESS_URL_ + "?" + StringUtils.generateQueryString(parameters, false);
        String result = WebUtils.get(url);

        AccessToken accessToken = null;
        if (result != null) {
            Gson gson = new Gson();
            accessToken = gson.fromJson(result, AccessToken.class);
        }

        return accessToken;
    }

    /**
     * 获得授权用户基本信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public UserInfo getUserInfo(String accessToken, String openId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("access_token", accessToken);
        parameters.put("openid", openId);
        parameters.put("lang", "zh_CN");

        String url = _USER_INFO_URL_ + "?" + StringUtils.generateQueryString(parameters, false);
        String result = WebUtils.get(url);

        UserInfo userInfo = null;
        if (result != null) {
            Gson gson = new Gson();
            userInfo = gson.fromJson(result, UserInfo.class);
        }

        return userInfo;
    }
}

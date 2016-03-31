/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import com.google.gson.Gson;
import net.yoomai.wechat.beans.qrcode.QRTicket;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.utils.WebUtils;

/**
 * 此能力模块对应微信的账号管理部分
 * 提供生成带参数的二维码,长连接转短连接以及微信认证的时间推送
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AccountCapability.java 1.0 31/03/2016
 */
public class AccountCapability extends AbstractCapability {

    /**
     * 创建二维码地址
     */
    private final static String _CREATE_QRCODE_ = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    /**
     * 用户展示或下载二维码的地址
     */
    private final static String _SHOW_QRCODE_ = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

    /**
     * 根据场景进行二维码的创建
     *
     * @param sceneId
     * @param actionName 永久还是临时
     * @return
     */
    public String createQRCode(String sceneId, String actionName, int expires, String accessToken) {
        String params = "{\"expire_seconds\": " + expires +
                ", \"action_name\": \"" + actionName +
                "\", \"action_info\": {\"scene\": {\"scene_id\": " + sceneId + "}}}";

        String url = _CREATE_QRCODE_ + "?access_token=" + accessToken;
        String result = WebUtils.post(url, params, WechatConfig._DATA_JSON_, false, null);
        Gson gson = new Gson();
        QRTicket qrTicket = gson.fromJson(result, QRTicket.class);

        return _SHOW_QRCODE_ + "?ticket=" + qrTicket.getTicket();
    }
}

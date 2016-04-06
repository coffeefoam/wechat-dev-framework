/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import com.google.gson.Gson;
import net.yoomai.wechat.beans.menus.MenuCreateReponse;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.utils.WebUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义菜单处理能力
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)MenusCapability.java 1.0 06/04/2016
 */
public class MenusCapability extends AbstractCapability {
    private final static String _MENU_CREATE_ = "https://api.weixin.qq.com/cgi-bin/menu/create";

    /**
     * 自定义菜单
     *
     * @param accessToken
     * @param menuContent
     * @return
     */
    public MenuCreateReponse create(String accessToken) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("menu.json");
        String content = "";
        try {
            content = IOUtils.toString(inputStream);
            logger.debug("菜单文件内容 \n {}", content);
        } catch (IOException e) {
            logger.error("读取自定义菜单文件的时候发生错误: {}", e.getMessage());
        }

        String url = _MENU_CREATE_ + "?access_token=" + accessToken;
        String ret = WebUtils.post(url, content, WechatConfig._DATA_JSON_, false, null);

        MenuCreateReponse menuCreateReponse = null;
        if (ret != null) {
            menuCreateReponse = new Gson().fromJson(ret, MenuCreateReponse.class);
        }

        return menuCreateReponse;
    }
}

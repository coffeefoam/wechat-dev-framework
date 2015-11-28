/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.config;

/**
 * 应用的配置项目
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AppConfig.java 1.0 27/11/2015
 */
public interface WechatConfig {
    /*
     * 微信appid
     */
    public static final String _APP_ID_ = "";

    /*
     * 微信秘钥
     */
    public static final String _APP_SECRET_ = "";

    /*
     * 微信商户账号
     */
    public static final String _WX_MCHID_ = "";

    /*
     * 微信商户KEY
     */
    public static final String _WX_MCH_KEY_ = "";

    /*
     * 微信商户证书位置
     */
    public static final String _WX_MCHID_PKCS_ = "";

    /*
     * 微信支付点对点通知地址
     */
    public static final String _PAY_NOTIFY_URL_ = "";

    /*
     * XML格式的数据
     */
    public static final String _DATA_XML_ = "xml";

    /*
     * JSON格式的数据
     */
    public static final String _DATA_JSON_ = "json";
}

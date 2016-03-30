/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 微信配置类,初始化一次
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)WxConfig.java 1.0 30/03/2016
 */
public class WxConfig {
    private final static Logger log = LoggerFactory.getLogger(WxConfig.class);

    /**
     * app id
     */
    private String appid;
    /**
     * app secret
     */
    private String appSecret;
    /**
     * 支付账户ID
     */
    private String mchid;
    /**
     * 支付账户KEY
     */
    private String mchKey;
    /**
     * 支付证书所在地址
     */
    private String mchPKCs;
    /**
     * 接受点对点通知URL
     */
    private String nofityURL;

    /**
     * 初始化微信配置模块
     *
     * @param id
     */
    public WxConfig(String id) {
        init(id);
    }

    public static Logger getLog() {
        return log;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getMchPKCs() {
        return mchPKCs;
    }

    public void setMchPKCs(String mchPKCs) {
        this.mchPKCs = mchPKCs;
    }

    public String getNofityURL() {
        return nofityURL;
    }

    public void setNofityURL(String nofityURL) {
        this.nofityURL = nofityURL;
    }

    /* $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
    /*          Private Methods          */
    /* $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */

    /*
     * 初始化各类参数
     */
    private void init(String id) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(id + ".properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("加载支付配置文件时发生错误 {}", e.getMessage());
            return;
        }

        this.appid = properties.getProperty("app.id");
        this.appSecret = properties.getProperty("app.secret");
        this.mchid = properties.getProperty("mch.id");
        this.mchKey = properties.getProperty("mch.key");
        this.mchPKCs = properties.getProperty("mch.pkcs");
        this.nofityURL = properties.getProperty("notify.url");
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 基础的能力模块
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AbstractCapability.java 1.0 20/01/2016
 */
public class AbstractCapability {
    private final static Logger log = LoggerFactory.getLogger(AbstractCapability.class);
    /**
     * app id
     */
    protected String appid;
    /**
     * app secret
     */
    protected String appSecret;
    /**
     * 支付账户ID
     */
    protected String mchid;
    /**
     * 支付账户KEY
     */
    protected String mchKey;
    /**
     * 支付证书所在地址
     */
    protected String mchPKCs;
    /**
     * 接受点对点通知URL
     */
    protected String nofityURL;

    /*
     * 初始化各类参数
     */
    protected void init(String id) {
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

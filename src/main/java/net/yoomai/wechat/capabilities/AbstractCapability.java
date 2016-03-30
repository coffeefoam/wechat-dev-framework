/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.capabilities;

import net.yoomai.wechat.config.WxConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础的能力模块
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AbstractCapability.java 1.0 20/01/2016
 */
public class AbstractCapability {
    protected Logger logger;
    /**
     * 微信配置模块
     */
    protected WxConfig wxConfig;

    public AbstractCapability() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public WxConfig getWxConfig() {
        return wxConfig;
    }

    public void setWxConfig(WxConfig wxConfig) {
        this.wxConfig = wxConfig;
    }
}

/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.converts;

import net.yoomai.wechat.beans.events.QRsceneEvent;
import net.yoomai.wechat.beans.events.SubscribeEvent;
import net.yoomai.wechat.exceptions.ConvertException;
import net.yoomai.wechat.utils.XmlUtils;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)EventConvert.java 1.0 04/04/2016
 */
public class EventConvert extends AppConvert {

    /**
     * 将通知的xml信息格式化为对象
     *
     * @param xmlContent
     * @param clazz
     * @param <T>
     * @return
     * @throws ConvertException
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(String xmlContent, Class<T> clazz) throws ConvertException {
        T o;
        try {
            o = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ConvertException("初始化格式化对象时发生错误", e);
        }

        if (o instanceof SubscribeEvent) {
            o = (T) convertSubscribeEvent(xmlContent);
        } else if (o instanceof QRsceneEvent) {
            o = (T) convertQRsceneEvent(xmlContent);
        }

        return o;
    }

    /**
     * 将对象转换为xml信息
     *
     * @param o
     * @return
     * @throws ConvertException
     */
    @Override
    public String reverse(Object o) throws ConvertException {
        return null;
    }


    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    // PRIVATE METHODS.
    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    /**
     * 格式化订阅或取消订阅的事件通知
     *
     * @param xmlContent
     * @return
     */
    private SubscribeEvent convertSubscribeEvent(String xmlContent) {
        return XmlUtils.toBean(xmlContent, SubscribeEvent.class);
    }

    /**
     * 格式化扫描带参数二维码的事件通知
     *
     * @param xmlContent
     * @return
     */
    private QRsceneEvent convertQRsceneEvent(String xmlContent) {
        return XmlUtils.toBean(xmlContent, QRsceneEvent.class);
    }
}

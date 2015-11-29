/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.converts;

import net.yoomai.wechat.exceptions.ConvertException;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)AppConvert.java 1.0 28/11/2015
 */
public abstract class AppConvert {
    protected String quotedCDATA(String data) {
        return "<![CDATA[" + data + "]]>";
    }

    /**
     * 将xml字符串信息转换成对象
     *
     * @return
     */
    public abstract <T> T convert(String xmlContent, Class<T> clazz) throws ConvertException;

    /**
     * 将对象转换成xml
     *
     * @param o
     * @return
     */
    public abstract String reverse(Object o) throws ConvertException;
}

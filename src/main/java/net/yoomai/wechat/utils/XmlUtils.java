/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * xml与bean互相转化的工具类
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)XmlUtils.java 1.0 29/11/2015
 */
public class XmlUtils {
    /**
     * 将对象转化为xml
     *
     * @param o
     * @return
     */
    public static String toXML(Object o) {
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("-_", "_")));
        xStream.processAnnotations(o.getClass());
        return xStream.toXML(o);
    }

    @SuppressWarnings("unchecked")
    /**
     * 将xml转化为对象
     */
    public static <T> T toBean(String xmlContent, Class<T> clazz) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(clazz);
        T target = (T) xStream.fromXML(xmlContent);

        return target;
    }
}

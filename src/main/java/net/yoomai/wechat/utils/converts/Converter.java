/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils.converts;

import org.w3c.dom.Node;

/**
 * 用于xml节点的转换
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)Convert.java 1.0 28/11/2015
 */
public abstract class Converter {
    private Converter nextConverter;

    protected String quotedCDATA(String data) {
        return "<![CDATA[" + data + "]]>";
    }

    public Converter nextConverter() {
        return nextConverter;
    }

    public void setNextConverter(Converter nextConverter) {
        this.nextConverter = nextConverter;
    }

    public abstract <T> T convert(Class<T> clazz, Node node) throws XmlConvertException;

    public abstract String reverse(Object obj) throws XmlConvertException;
}

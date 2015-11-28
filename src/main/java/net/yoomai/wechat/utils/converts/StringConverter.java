/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils.converts;

import org.w3c.dom.Node;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)StringConverter.java 1.0 28/11/2015
 */
public class StringConverter extends Converter {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
        if (clazz.getName().equals("java.lang.String")) {
            return (T) node.getFirstChild().getNodeValue();
        } else {
            if (this.nextConverter() != null) {
                return this.nextConverter().convert(clazz, node);
            } else {
                return null;
            }
        }
    }

    @Override
    public String reverse(Object obj) throws XmlConvertException{
        if (obj.getClass().getName().equals("java.lang.String")) {
            return quotedCDATA(String.valueOf(obj));
        } else {
            if (this.nextConverter() != null) {
                return this.nextConverter().reverse(obj);
            } else {
                return "";
            }
        }
    }
}

/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils.converts;

import org.w3c.dom.Node;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)NodeConverter.java 1.0 28/11/2015
 */
public class NodeConverter extends Converter {

    @Override
    public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
        if (Node.ELEMENT_NODE == node.getNodeType()) {
            if (this.nextConverter() != null) {
                return this.nextConverter().convert(clazz, node);
            } else {
                return null;
            }
        } else {
            throw new XmlConvertException("Only element node can convert to field, " + node.getNodeName() + " is " +
                    node.getNodeType());
        }
    }

    @Override
    public String reverse(Object obj) throws XmlConvertException {
        if (null != this.nextConverter()) {
            return this.nextConverter().reverse(obj);
        } else {
            return "";
        }
    }
}

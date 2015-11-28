/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils.converts;

import org.w3c.dom.Node;

import java.io.UnsupportedEncodingException;

/**
 * 基础类型转换
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PrimitiveConverter.java 1.0 28/11/2015
 */
public class PrimitiveConverter extends Converter {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(Class<T> clazz, Node node) throws XmlConvertException {
        if (clazz.isPrimitive()) {
            String className = clazz.getName();
            try {
                if (className.equals("byte")) {
                    return (T) (new Byte(node.getFirstChild().getNodeValue()));
                } else if (className.equals("short")) {
                    return (T) (new Short(node.getFirstChild().getNodeValue()));
                } else if (className.equals("int")) {
                    return (T) (new Integer(node.getFirstChild().getNodeValue()));
                } else if (className.equals("long")) {
                    return (T) (new Long(node.getFirstChild().getNodeValue()));
                } else if (className.equals("float")) {
                    return (T) (new Float(node.getFirstChild().getNodeValue()));
                } else if (className.equals("double")) {
                    return (T) (new Double(node.getFirstChild().getNodeValue()));
                } else if (className.equals("char")) {
                    return (T) (new Character(node.getFirstChild().getNodeValue().charAt(0)));
                } else if (className.equals("boolean")) {
                    return (T) (new Boolean(node.getFirstChild().getNodeValue()));
                } else {
                    return null;
                }
            } catch (ClassCastException e) {
                throw new XmlConvertException(node.getFirstChild().getNodeValue() + " cann't cast to " + className);
            }
        } else {
            if (null != this.nextConverter()) {
                return this.nextConverter().convert(clazz, node);
            } else {
                return null;
            }
        }
    }

    @Override
    public String reverse(Object obj) throws XmlConvertException{
        String className = obj.getClass().getName();
        try {
            if (className.equals("java.lang.Byte")) {
                byte[] b = new byte[1];
                b[0] = (byte) obj;
                try {
                    return quotedCDATA(new String(b, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new XmlConvertException("Create string from byte failed.", e);
                }
            } else if (className.equals("java.lang.Short")) {
                return String.valueOf((int) obj);
            } else if (className.equals("java.lang.Integer")) {
                return String.valueOf((int) obj);
            } else if (className.equals("java.lang.Long")) {
                return String.valueOf((long) obj);
            } else if (className.equals("java.lang.Float")) {
                return String.valueOf((float) obj);
            } else if (className.equals("java.lang.Double")) {
                return String.valueOf((double) obj);
            } else if (className.equals("java.lang.Char")) {
                return quotedCDATA(String.valueOf((char) obj));
            } else if (className.equals("java.lang.Boolean")) {
                return quotedCDATA(String.valueOf((boolean) obj));
            } else {
                if (null != this.nextConverter()) {
                    return this.nextConverter().reverse(obj);
                } else {
                    return "";
                }
            }
        } catch (ClassCastException e) {
            throw new XmlConvertException(obj.toString() + " cann't cast to " + className);
        }
    }
}

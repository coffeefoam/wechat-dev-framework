/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils;

import net.yoomai.wechat.utils.converts.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理xml的转换的辅助工具类
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)XmlUtils.java 1.0 27/11/2015
 */
public class XmlUtils {
    private static final Logger log = LoggerFactory.getLogger(XmlUtils.class);

    private Document document;

    /**
     * 解析xml内容
     *
     * @param xmlContent
     */
    public void parseDocument(String xmlContent) throws XmlParseException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XmlParseException("获得XML文档builder时发生错误", e);
        }

        if (builder == null) {
            log.error("文档工厂没有创建成功");
        } else {
            try {
                document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes()));
            } catch (SAXException e) {
                throw new XmlParseException("解析xml文档时发生错误 {}", e);
            } catch (IOException e) {
                throw new XmlParseException("读取xml流信息时发生错误 {}", e);
            }
        }
    }

    /**
     * 根据xml的内容，通过反射实体，进行赋值
     *
     * @param clazz
     * @param xmlContent
     * @param <T>
     * @return
     */
    public <T> T convertToObject(Class<T> clazz, String xmlContent) throws XmlParseException, XmlConvertException {

        Map<String, Method> setters = retrieveSetters(clazz.getMethods());
        parseDocument(xmlContent);

        T obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new XmlConvertException("创建 " + clazz.getName() + "实例时发生错误", e);
        }

        for (String fieldName : setters.keySet()) {
            NodeList nodes = document.getElementsByTagName(fieldName);
            Method setter = setters.get(fieldName);
            Class<?>[] paramTypes = setter.getParameterTypes();
            if (paramTypes.length > 1) {
                throw new XmlConvertException("Field " + fieldName + "'s setter has more then one parameter.");
            } else if (paramTypes.length <= 0) {
                throw new XmlConvertException("Field " + fieldName + "'s setter has no parameter.");
            }

            if (nodes.getLength() <= 0) {
                try {
                    setter.invoke(obj, new Object[]{null});
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new XmlConvertException("Invoke method " + setter.getName() + " failed.", e);
                }

                continue;
            }

            Converter converter = converterBuilder();
            try {
                setter.invoke(obj, converter.convert(paramTypes[0], nodes.item(0)));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new XmlConvertException("Invoke method " + setter.getName() + " failed.", e);
            }
        }

        return obj;
    }

    /**
     * 将对象返序列化为xml文档
     *
     * @param obj
     * @return
     * @throws XmlConvertException
     */
    public String save(Object obj) throws XmlConvertException{
        Map<String, Method> getters = retrieveGetters(obj.getClass().getMethods());
        Converter converter = converterBuilder();
        String xml = "<xml>\r\n";
        for (String fieldName : getters.keySet()) {
            if (fieldName.equals("Class")) {
                continue;
            }
            Method getter = getters.get(fieldName);
            Object value = null;
            try {
                value = getter.invoke(obj);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new XmlConvertException("Invoke method " + getter.getName() + " failed.", e);
            }

            String xmlValue = converter.reverse(value);
            if (!xmlValue.isEmpty()) {
                xml += "\t<" + fieldName + ">" + xmlValue + "</" + fieldName + ">\r\n";
            } else {
                xml += "\t<" + fieldName + "/>\r\n";
            }
        }
        xml += "</xml>";

        return xml;
    }

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    //  PRIVATE METHOD
    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    private Map<String, Method> retrieveSetters(Method[] methods) {
        Map<String, Method> setters = new HashMap<String, Method>();
        for (Method method : methods) {
            if (method.getName().substring(0, 3).equals("set")) {
                String fieldName = method.getName().substring(3, method.getName().length());
                setters.put(fieldName, method);
            }
        }
        return setters;
    }

    private Map<String, Method> retrieveGetters(Method[] methods) {
        Map<String, Method> getters = new HashMap<String, Method>();
        for (Method method : methods) {
            if (method.getName().substring(0, 3).equals("get")) {
                String fieldName = method.getName().substring(3, method.getName().length());
                getters.put(fieldName, method);
            }
        }
        return getters;
    }

    private Converter converterBuilder() {
        NodeConverter nodeConverter = new NodeConverter();
        PrimitiveConverter primitiveConverter = new PrimitiveConverter();
        StringConverter stringConverter = new StringConverter();

        nodeConverter.setNextConverter(primitiveConverter);
        primitiveConverter.setNextConverter(stringConverter);
        return nodeConverter;
    }
}

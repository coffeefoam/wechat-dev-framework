/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils;

import net.yoomai.wechat.config.WechatConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户通过网络提交或获取数据信息
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)WebUtils.java 1.0 27/11/2015
 */
public class WebUtils {
    private static final Logger log = LoggerFactory.getLogger(WebUtils.class);

    /**
     * 获得客户端真是ip
     *
     * @param request
     * @return
     */
    public static String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * GET方法获得网络信息
     *
     * @param url 带参数的地址
     * @return 如果发生IO异常，则会返回null
     */
    public static String get(String url) {
        String result = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            log.error("调用GET方法获取网络信息时发生错误: {}", e.getMessage());
            response = null;
        }

        if (response != null) {
            HttpEntity entity = response.getEntity();
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200 || statusLine.getStatusCode() == 302) {
                try {
                    result = EntityUtils.toString(entity, "UTF-8");
                } catch (IOException e) {
                    log.error("进行实体转换时发生错误: {}", e.getMessage());
                    result = null;
                }
            }
        }

        return result;
    }

    /**
     * 用post方式提交数据，仅支持普通数据提交
     *
     * @param url
     * @param parameters
     * @return
     */
    public static String post(String url, List<NameValuePair> parameters) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        boolean executeStatus = true;
        HttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
            response = httpClient.execute(httpPost);
        } catch (UnsupportedEncodingException e) {
            log.error("不支持编码方式 {}", e.getMessage());
            executeStatus = false;
        } catch (ClientProtocolException e) {
            log.error("协议不支持 {}", e.getMessage());
            executeStatus = false;
        } catch (IOException e) {
            log.error("发生IO异常 {}", e.getMessage());
            executeStatus = false;
        }

        if (executeStatus) {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200 || statusLine.getStatusCode() == 302) {
                HttpEntity entity = response.getEntity();
                try {
                    result = EntityUtils.toString(entity, "UTF-8");
                } catch (IOException e) {
                    log.error("解析响应实体时发生错误 {}", e.getMessage());
                    result = null;
                }
            }
        }

        return result;
    }


    /**
     * 提交xml或者json数据到指定的地址
     *
     * @param url
     * @param obj
     * @param type
     * @param cert
     * @return
     */
    public static String post(String url, String obj, String type, boolean cert, SSLContext sslContext) {
        String result = null;

        List<NameValuePair> headers = new ArrayList<>();
        if (WechatConfig._DATA_XML_.equals(type)) {
            headers.add(new BasicNameValuePair("Content-Type", "text/xml"));
        } else if (WechatConfig._DATA_JSON_.equals(type)) {
            headers.add(new BasicNameValuePair("Content-Type", "application/json"));
        }

        return post(url, obj, headers, cert, sslContext);
    }

    /**
     * 提交xml或者json数据到指定的地址
     *
     * @param url
     * @param obj
     * @param headers
     * @param cert
     * @param sslContext
     * @return
     */
    public static String post(String url, String obj, List<NameValuePair> headers, boolean cert, SSLContext sslContext) {
        String result = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        if (cert) {
            try {
                // Allow TLSv1 protocol only
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                        sslContext,
                        new String[]{"TLSv1"},
                        null,
                        SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            } catch (Exception e) {
                log.error("初始化KeyStore错误 {}", e.getMessage());
            }
        }

        for (NameValuePair nameValuePair : headers) {
            httpPost.setHeader(nameValuePair.getName(), nameValuePair.getValue());
        }

        StringEntity entity = new StringEntity(obj, "UTF-8");
        httpPost.setEntity(entity);

        boolean status = true;
        HttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            log.error("发生IO错误 {}", e.getMessage());
            status = false;
        }

        if (status) {
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200 || statusLine.getStatusCode() == 302) {
                try {
                    result = EntityUtils.toString(response.getEntity(), "UTF-8");
                } catch (IOException e) {
                    log.error("解析响应实体发生错误 {}", e.getMessage());
                }
            }
        }

        return result;
    }

    /**
     * 设置客户端cookie
     *
     * @param response
     * @param name
     * @param value
     * @param age
     * @param path
     * @param domain
     */
    public static void setCookie(HttpServletResponse response, String name,
                                 String value, int age, String path, String domain) {
        Cookie cookie = new Cookie(name, value);
        if (age > 0) {
            cookie.setMaxAge(age);
        }
        cookie.setPath(path);
        if (domain != null) {
            cookie.setDomain(domain);
        }

        response.addCookie(cookie);
    }

    /**
     * 获取cookie信息
     *
     * @param name
     * @param request
     * @return
     */
    public static String getCookie(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "";
        }
        String cookieValue = "";
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
                break;
            }
        }

        return cookieValue;
    }

}

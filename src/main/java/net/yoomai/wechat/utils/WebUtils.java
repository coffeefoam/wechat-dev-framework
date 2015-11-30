/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.utils;

import net.yoomai.wechat.config.WechatConfig;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
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

        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (cert) {
            try {
                // Allow TLSv1 protocol only
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                        sslContext,
                        new String[] { "TLSv1" },
                        null,
                        SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            } catch (Exception e) {
                log.error("初始化KeyStore错误 {}", e.getMessage());
            }
        }

        HttpPost httpPost = new HttpPost(url);
        if (WechatConfig._DATA_XML_.equals(type)) {
            httpPost.setHeader("Content-Type", "text/xml");
        } else if (WechatConfig._DATA_JSON_.equals(type)) {
            httpPost.setHeader("Content-Type", "application/json");
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
}

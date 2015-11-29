/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.test;

import net.yoomai.wechat.beans.payment.PayParams;
import net.yoomai.wechat.beans.payment.PayStatus;
import net.yoomai.wechat.config.WechatConfig;
import net.yoomai.wechat.converts.AppConvert;
import net.yoomai.wechat.converts.PayConvert;
import net.yoomai.wechat.exceptions.ConvertException;
import net.yoomai.wechat.utils.StringUtils;
import net.yoomai.wechat.utils.XmlUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)XmlConvertTest.java 1.0 29/11/2015
 */
public class XmlConvertTest {
    @Test
    public void testReversePayParams() throws ConvertException {
        String nonceStr = StringUtils.randomString(8);
        // 此处写的好不优雅，有时间的话调整一下吧，OMG
        Map<String, Object> params = new HashMap<>();
        params.put("appid",WechatConfig._APP_ID_);
        params.put("body", "测试");
        params.put("mch_id", WechatConfig._WX_MCHID_);
        params.put("nonce_str", nonceStr);
        params.put("notify_url", WechatConfig._PAY_NOTIFY_URL_);
        params.put("openid", "123456789");
        params.put("out_trade_no", "01234567");
        params.put("spbill_create_ip", "127.0.0.1");
        params.put("total_fee", String.valueOf(1));
        params.put("trade_type", "JSAPI");
        params.put("key", WechatConfig._WX_MCH_KEY_);
        String sign = StringUtils.signature(params, "MD5", true);

        PayParams payParams = new PayParams(
                WechatConfig._APP_ID_, WechatConfig._WX_MCHID_, nonceStr, sign, "测试", "01234567", 1, "127.0.0.1",
                WechatConfig._PAY_NOTIFY_URL_, "JSAPI", "123456789"
        );

        AppConvert convert = new PayConvert();
        String xmlContent = convert.reverse(payParams);
        System.out.println(xmlContent);
    }

    @Test
    public void testConvertPayParams() {
        String xml = "<xml>\n" +
                "  <appid></appid>\n" +
                "  <mch_id></mch_id>\n" +
                "  <nonce_str>OO8R5RBf</nonce_str>\n" +
                "  <sign>902438350DB5FAC85FE8F381E5C6D739</sign>\n" +
                "  <body>测试</body>\n" +
                "  <out_treade_no>01234567</out_treade_no>\n" +
                "  <total_fee>1</total_fee>\n" +
                "  <spbill_create_ip>127.0.0.1</spbill_create_ip>\n" +
                "  <notify_url></notify_url>\n" +
                "  <trade_type>JSAPI</trade_type>\n" +
                "  <openid>123456789</openid>\n" +
                "</xml>";

        PayParams payParams = XmlUtils.toBean(xml, PayParams.class);
        System.out.println(payParams.getSign());
    }
}

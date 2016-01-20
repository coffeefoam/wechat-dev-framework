/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.test;

import net.yoomai.wechat.beans.messages.TextMessage;
import net.yoomai.wechat.beans.payment.NotifyStatus;
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
//        Map<String, Object> params = new HashMap<>();
//        params.put("appid",WechatConfig._APP_ID_);
//        params.put("body", "测试");
//        params.put("mch_id", WechatConfig._WX_MCHID_);
//        params.put("nonce_str", nonceStr);
//        params.put("notify_url", WechatConfig._PAY_NOTIFY_URL_);
//        params.put("openid", "123456789");
//        params.put("out_trade_no", "01234567");
//        params.put("spbill_create_ip", "127.0.0.1");
//        params.put("total_fee", String.valueOf(1));
//        params.put("trade_type", "JSAPI");
//        params.put("key", WechatConfig._WX_MCH_KEY_);
//        String sign = StringUtils.signature(params, "MD5", true);
//
//        PayParams payParams = new PayParams(
//                WechatConfig._APP_ID_, WechatConfig._WX_MCHID_, nonceStr, sign, "测试", "01234567", 1, "127.0.0.1",
//                WechatConfig._PAY_NOTIFY_URL_, "JSAPI", "123456789"
//        );

        AppConvert convert = new PayConvert();
//        String xmlContent = convert.reverse(payParams);
//        System.out.println(xmlContent);
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

    @Test
    public void testConvertTextMessage() {
        String xml = "<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName> \n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a test]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        TextMessage textMessage = XmlUtils.toBean(xml, TextMessage.class);
        System.out.println(textMessage.getMsgType());
    }

    @Test
    public void testConvertNotifyStatus() {
        String xml = " <xml><appid><![CDATA[wxd1c6bec576123e7b]]></appid>\n" +
                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                "<cash_fee><![CDATA[1]]></cash_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1262208501]]></mch_id>\n" +
                "<nonce_str><![CDATA[2YL8V6zQ]]></nonce_str>\n" +
                "<openid><![CDATA[o_A4QuB6bRUZoYP82oC8pdmsvOJo]]></openid>\n" +
                "<out_trade_no><![CDATA[28]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[32C977A580C9E2DEE6D01E12D357994D]]></sign>\n" +
                "<time_end><![CDATA[20151209121930]]></time_end>\n" +
                "<total_fee>1</total_fee>\n" +
                "<trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "<transaction_id><![CDATA[1002200853201512091977269291]]></transaction_id>\n" +
                "</xml>";
        NotifyStatus notifyStatus = XmlUtils.toBean(xml, NotifyStatus.class);
        System.out.println(notifyStatus.getTransactionId());
    }
}

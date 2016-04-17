/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.converts;

import net.yoomai.wechat.beans.payment.*;
import net.yoomai.wechat.beans.payment.bizpay.BizpayParams;
import net.yoomai.wechat.beans.payment.bizpay.BizpayResponse;
import net.yoomai.wechat.exceptions.ConvertException;
import net.yoomai.wechat.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付相关的参数与响应的串行化处理，格式为xml
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PayConvert.java 1.0 28/11/2015
 */
public class PayConvert extends AppConvert {
    private static final Logger log = LoggerFactory.getLogger(PayConvert.class);

    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(String xmlContent, Class<T> clazz) throws ConvertException {
        T o;
        try {
            o = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ConvertException("初始化格式化对象时发生错误", e);
        }

        if (o instanceof PayStatus) {
            o = (T) convertPayStatus(xmlContent);
        } else if (o instanceof OrderQueryResponse) {
            o = (T) convertOrderQueryResponse(xmlContent);
        } else if (o instanceof RefundResponse) {
            o = (T) convertRefundResponse(xmlContent);
        } else if (o instanceof NotifyStatus) {
            o = (T) convertNotifyStatus(xmlContent);
        } else if (o instanceof BizpayParams) {
            o = (T) convertBizpayParams(xmlContent);
        } else if (o instanceof TransferResponse) {
            o = (T) convertTransferResponse(xmlContent);
        } else if (o instanceof TransferQueryResponse) {
            o = (T) convertTransferQueryResponse(xmlContent);
        } else {
            throw new ConvertException("格式化支付响应信息目前只支持点对点回调状态，订单查询响应以及退款操作的响应三种类型");
        }
        return o;
    }

    @Override
    public String reverse(Object o) throws ConvertException {
        if (o instanceof PayParams) {
            return reversePayParams((PayParams) o);
        } else if (o instanceof OrderQueryParams) {
            return reverseOrderQueryParams((OrderQueryParams) o);
        } else if (o instanceof RefundParams) {
            return reverseRefundParams((RefundParams) o);
        } else if (o instanceof BizpayResponse) {
            return reverseBizpayResponse((BizpayResponse) o);
        } else if (o instanceof TransferParams) {
            return reverseTransferParams((TransferParams) o);
        } else if (o instanceof TransferQueryParams) {
            return reverseTransferQueryParams((TransferQueryParams) o);
        } else {
            throw new ConvertException("支付相关参数转换只支持支付参数，退款参数以及订单查询参数三种类型.");
        }
    }

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    // PRIVATE METHODS.
    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    /**
     * 转换支付参数
     *
     * @param payParams
     * @return
     */
    private String reversePayParams(PayParams payParams) {
        return XmlUtils.toXML(payParams);
    }

    /**
     * 转换订单查询参数
     *
     * @param orderQueryParams
     * @return
     */
    private String reverseOrderQueryParams(OrderQueryParams orderQueryParams) {
        return XmlUtils.toXML(orderQueryParams);
    }

    /**
     * 转换退款参数
     *
     * @param refundParams
     * @return
     */
    private String reverseRefundParams(RefundParams refundParams) {
        return XmlUtils.toXML(refundParams);
    }

    /**
     * 转换扫码支付响应
     *
     * @param bizpayResponse
     * @return
     */
    private String reverseBizpayResponse(BizpayResponse bizpayResponse) {
        return XmlUtils.toXML(bizpayResponse);
    }

    /**
     * 转换企业支付请求参数
     *
     * @param transferParams
     * @return
     */
    private String reverseTransferParams(TransferParams transferParams) {
        return XmlUtils.toXML(transferParams);
    }

    /**
     * 转换企业支付查询请求参数
     *
     * @param transferQueryParams
     * @return
     */
    private String reverseTransferQueryParams(TransferQueryParams transferQueryParams) {
        return XmlUtils.toXML(transferQueryParams);
    }


    /**
     * 格式化支付响应
     *
     * @param xmlContent
     * @return
     */
    private PayStatus convertPayStatus(String xmlContent) {
        return XmlUtils.toBean(xmlContent, PayStatus.class);
    }

    /**
     * 格式化点对点状态
     *
     * @param xmlContent
     * @return
     */
    private NotifyStatus convertNotifyStatus(String xmlContent) {
        log.debug("点对点信息 {}", xmlContent);
        return XmlUtils.toBean(xmlContent, NotifyStatus.class);
    }

    /**
     * 格式化订单查询响应信息
     *
     * @param xmlContent
     * @return
     */
    private OrderQueryResponse convertOrderQueryResponse(String xmlContent) {
        return XmlUtils.toBean(xmlContent, OrderQueryResponse.class);
    }

    /**
     * 格式化退款响应信息
     * N
     *
     * @param xmlContent
     * @return
     */
    private RefundResponse convertRefundResponse(String xmlContent) {
        return XmlUtils.toBean(xmlContent, RefundResponse.class);
    }

    /**
     * 格式化接收到的扫码支付信息
     *
     * @param xmlContent
     * @return
     */
    private BizpayParams convertBizpayParams(String xmlContent) {
        return XmlUtils.toBean(xmlContent, BizpayParams.class);
    }

    /**
     * 格式化接收到的企业支付响应
     *
     * @param xmlContent
     * @return
     */
    private TransferResponse convertTransferResponse(String xmlContent) {
        return XmlUtils.toBean(xmlContent, TransferResponse.class);
    }

    /**
     * 格式化企业支付查询的响应信息
     *
     * @param xmlContent
     * @return
     */
    private TransferQueryResponse convertTransferQueryResponse(String xmlContent) {
        return XmlUtils.toBean(xmlContent, TransferQueryResponse.class);
    }
}

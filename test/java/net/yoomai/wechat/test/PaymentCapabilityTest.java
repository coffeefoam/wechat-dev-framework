/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.test;

import net.yoomai.wechat.beans.payment.OrderQueryResponse;
import net.yoomai.wechat.capabilities.PaymentCapability;
import net.yoomai.wechat.exceptions.ConvertException;
import net.yoomai.wechat.exceptions.OrderQueryException;
import org.junit.Test;

/**
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PaymentCapabilityTest.java 1.0 18/01/2016
 */
public class PaymentCapabilityTest {
    @Test
    public void testQuery() throws ConvertException, OrderQueryException {
        PaymentCapability paymentCapability = new PaymentCapability();
        OrderQueryResponse orderQueryResponse = paymentCapability.orderQuery("201601191026041453170364412");
    }
}

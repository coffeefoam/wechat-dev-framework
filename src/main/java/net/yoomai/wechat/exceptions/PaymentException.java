/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.exceptions;

/**
 * 支付的异常
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)PaymentException.java 1.0 30/11/2015
 */
public class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}

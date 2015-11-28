/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.exceptions;

/**
 * 订单查询的异常
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)OrderQueryException.java 1.0 28/11/2015
 */
public class OrderQueryException extends Exception {
    public OrderQueryException(String message) {
        super(message);
    }

    public OrderQueryException(String message, Throwable cause) {
        super(message, cause);
    }
}

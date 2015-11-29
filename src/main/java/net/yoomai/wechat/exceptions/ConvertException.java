/**
 * Copyright (c) 2014, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.exceptions;

/**
 * xml格式转换异常
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)ConvertException.java 1.0 29/11/2015
 */
public class ConvertException extends Exception {
    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String message, Throwable cause) {
        super(message, cause);
    }
}

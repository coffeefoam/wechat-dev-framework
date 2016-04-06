/**
 * Copyright (c) 2015-2016, wolaiyee.com. All rights reserved.
 * wolaiyee.com. Use is subject to license terms.
 */
package net.yoomai.wechat.beans.menus;

/**
 * 创建菜单的反馈内容
 *
 * @author Ray & coffeefoam@126.com & http://github.com/coffeefoam
 * @(#)MenuCreateReponse.java 1.0 06/04/2016
 */
public class MenuCreateReponse {
    private String errcode;
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

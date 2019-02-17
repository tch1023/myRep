package com.itheima.domain;

/**
 * 自定义异常类
 * @Author: tch
 * @Date: 2019/2/14 下午 02:45
 */
public class SysException extends Exception {
    private static final long  serialVersionUID = 4055945147128016300L;

    //异常提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

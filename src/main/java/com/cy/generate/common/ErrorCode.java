package com.cy.generate.common;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 15:50
 */
public enum ErrorCode {

    //常用
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    UNKNOW(404, "未知"),
    EXCEPTION(500, "内部错误"),

    //系统
    SERVER_BUSY(10000, "系统繁忙，此时请开发者稍候再试"),
    ERROR(10001, "错误"),
    SERVER_NOTFOUND(10002, "服务器错误"),

    //账户
    ACCOUNT_NOT_FOUND(20000, "用户未找到");


    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(name());
    }
}

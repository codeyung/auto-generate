package com.cy.generate.common;

import java.io.Serializable;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 15:49
 */
public class BaseResponse<T> implements Serializable {

    /**
     * 请求结果
     */
    private boolean success;
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 详细描述
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;


    public BaseResponse() {
        super();
        this.setSuccess(false);
    }

    public BaseResponse(boolean success) {
        super();
        this.setSuccess(success);
    }

    public BaseResponse(T data) {
        super();
        this.setSuccess(success);
        this.data = data;
    }

    public BaseResponse(T data, String msg) {
        super();
        this.setSuccess(success);
        this.data = data;
        this.msg = msg;
    }

    public BaseResponse(Throwable e, ErrorCode errorCode) {
        super();
        this.setError(errorCode);
        this.setError(e);
    }

    public void setSuccess(boolean success) {
        this.success = success;
        this.code = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.name();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setError(ErrorCode errorCode) {
        this.success = false;
        this.code = errorCode.getCode();
        this.msg = errorCode.name();
        this.message = errorCode.getMessage();
    }

    public void setError(Throwable e) {
        this.message = e.getMessage();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


}

package com.cy.generate.common.exception;

import com.cy.generate.common.ErrorCode;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/20 16:20
 */
public class CommonException extends RuntimeException {

    private ErrorCode errorCode;

    public CommonException() {
    }

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(Throwable throwable) {
        super(throwable);
    }

    public CommonException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CommonException(String msg, ErrorCode errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public CommonException(Throwable throwable, ErrorCode errorCode) {
        super(throwable);
        this.errorCode = errorCode;
    }

    public CommonException(String msg, Throwable throwable, ErrorCode errorCode) {
        super(msg, throwable);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}

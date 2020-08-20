package com.cy.generate.exception;


import com.cy.generate.common.ErrorCode;
import com.cy.generate.common.exception.CommonException;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/20 16:29
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            throw new CommonException(new RuntimeException("固定异常"), ErrorCode.ERROR);
        } catch (CommonException e) {
            System.out.println(e.getErrorCode());
        }

    }
}

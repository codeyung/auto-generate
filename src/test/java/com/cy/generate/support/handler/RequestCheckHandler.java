package com.cy.generate.support.handler;


import com.cy.generate.support.BaseHandler;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
public class RequestCheckHandler extends BaseHandler {

    @Override
    protected boolean executeFlag() {
        return true;
    }

    @Override
    protected void execute() {
        System.out.println("RequestCheckHandler-execute");
    }
}

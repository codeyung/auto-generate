package com.cy.generate.support.handler;


import com.cy.generate.support.BaseHandler;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
public class TokenCheckHandler extends BaseHandler {

    @Override
    public boolean executeFlag() {
        return true;
    }

    @Override
    public void execute() {
        System.out.println("TokenCheckHandler-execute");
    }
}

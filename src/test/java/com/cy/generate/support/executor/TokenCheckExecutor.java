package com.cy.generate.support.executor;


import com.cy.generate.support.BaseExecutor;
import com.cy.generate.support.handler.TokenCheckHandler;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 13:58
 */
public class TokenCheckExecutor extends BaseExecutor {

    public TokenCheckExecutor(TokenCheckHandler handler) {
        super.registHandlers(handler);
    }

    @Override
    protected void parallel() {

    }

}

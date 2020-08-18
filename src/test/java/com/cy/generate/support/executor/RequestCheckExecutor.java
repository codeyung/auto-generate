package com.cy.generate.support.executor;


import com.cy.generate.support.BaseExecutor;
import com.cy.generate.support.handler.RequestCheckHandler;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 13:58
 */
public class RequestCheckExecutor extends BaseExecutor {

    public RequestCheckExecutor(RequestCheckHandler handler) {
        super.registHandlers(handler);
    }

    @Override
    protected void parallel() {

    }

}

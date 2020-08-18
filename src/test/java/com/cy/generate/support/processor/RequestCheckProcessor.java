package com.cy.generate.support.processor;


import com.cy.generate.support.BaseProcessor;
import com.cy.generate.support.executor.RequestCheckExecutor;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 13:53
 */
public class RequestCheckProcessor extends BaseProcessor {

    public RequestCheckProcessor(RequestCheckExecutor executor) {
        super.registExecutor(executor);
    }

    @Override
    protected boolean executeFlag() {
        return true;
    }
}

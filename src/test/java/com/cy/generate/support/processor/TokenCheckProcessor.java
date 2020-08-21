package com.cy.generate.support.processor;


import com.cy.generate.support.BaseProcessor;
import com.cy.generate.support.executor.TokenCheckExecutor;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:53
 */
public class TokenCheckProcessor extends BaseProcessor {

    public TokenCheckProcessor(TokenCheckExecutor executor) {
        super.registExecutor(executor);
    }

    @Override
    protected boolean executeFlag() {
        return true;
    }
}

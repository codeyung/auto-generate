package com.cy.generate.support.chain;


import com.cy.generate.support.BaseProcessorChain;
import com.cy.generate.support.processor.RequestCheckProcessor;
import com.cy.generate.support.processor.TokenCheckProcessor;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 14:09
 */
public class CheckProcessorChain extends BaseProcessorChain {

    public CheckProcessorChain(RequestCheckProcessor requestCheckProcessor, TokenCheckProcessor tokenCheckProcessor) {
        super.registProcessor(requestCheckProcessor, tokenCheckProcessor);
    }

    @Override
    protected void parallel() {

    }
}

package com.cy.generate.facade;


import com.cy.generate.support.BaseProcessorChainFactory;
import com.cy.generate.support.chain.CheckProcessorChain;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 14:08
 */
public class CheckFacade extends BaseProcessorChainFactory {

    public CheckFacade(CheckProcessorChain chain) {
        super.registChain(chain);
    }

    @Override
    protected void validate(Object param) {
        System.out.println("CheckFacade-validate: " + param);
    }
}

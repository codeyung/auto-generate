package com.cy.generate.support.beta;


import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
@Service
public class Handler1 implements IHandler {

    @Override
    public boolean executeFlag() {
        return true;
    }

    @Override
    public void execute() {
    }
}

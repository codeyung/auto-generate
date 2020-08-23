package com.cy.generate.support.beta;


import com.cy.generate.common.exception.CommonException;
import com.cy.generate.support.BaseHandler;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
@Service
public class Handler2 extends BaseHandler {

    @Override
    public boolean executeFlag() {
        return true;
    }

    @Override
    public void execute() {

        throw new CommonException("1测试");
    }
}

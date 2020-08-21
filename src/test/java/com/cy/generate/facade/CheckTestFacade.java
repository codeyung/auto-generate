package com.cy.generate.facade;


import com.cy.generate.support.chain.CheckProcessorChain;
import com.cy.generate.support.executor.RequestCheckExecutor;
import com.cy.generate.support.executor.TokenCheckExecutor;
import com.cy.generate.support.handler.RequestCheckHandler;
import com.cy.generate.support.handler.TokenCheckHandler;
import com.cy.generate.support.holder.ContextHolder;
import com.cy.generate.support.processor.RequestCheckProcessor;
import com.cy.generate.support.processor.TokenCheckProcessor;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 14:08
 */
public class CheckTestFacade {

    private ContextHolder contextHolder = new ContextHolder();

    //step 1
    private RequestCheckHandler requestCheckHandler;
    private TokenCheckHandler tokenCheckHandler;
    //step 2
    private RequestCheckExecutor requestCheckExecutor;
    private TokenCheckExecutor tokenCheckExecutor;
    //step 3
    private RequestCheckProcessor requestCheckProcessor;
    private TokenCheckProcessor tokenCheckProcessor;
    //step 4
    private CheckProcessorChain checkProcessorChain;
    private CheckFacade checkFacade;

    /**
     * 验证整体流程
     */
    public void testCheck() {
        String request = "requestParam";
        contextHolder.bindRequest(request);

        //step 1
        requestCheckHandler = new RequestCheckHandler();
        tokenCheckHandler = new TokenCheckHandler();
        //step 2
        requestCheckExecutor = new RequestCheckExecutor(requestCheckHandler);
        tokenCheckExecutor = new TokenCheckExecutor(tokenCheckHandler);
        //step 3
        requestCheckProcessor = new RequestCheckProcessor(requestCheckExecutor);
        tokenCheckProcessor = new TokenCheckProcessor(tokenCheckExecutor);
        //step 4
        checkProcessorChain = new CheckProcessorChain(requestCheckProcessor, tokenCheckProcessor);
        checkFacade = new CheckFacade(checkProcessorChain);
        checkFacade.param(contextHolder.getRequest()).doChain();

        contextHolder.clear();

    }

    public static void main(String[] args) {
        CheckTestFacade checkTestFacade = new CheckTestFacade();
        checkTestFacade.testCheck();
    }


}

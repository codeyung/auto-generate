package com.cy.generate.controller;


import com.cy.generate.domain.DemoObject;
import com.cy.generate.service.DemoService;
import com.cy.generate.support.BaseHandler;
import com.cy.generate.support.beta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 23:23
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    public DemoObject test() {
        return demoService.test();
    }


    @Lookup
    public BetaProcessor<BaseHandler> betaProcessor() {
        return null;
    }

    @Autowired
    private Processor1 processor1;

    @Autowired
    private Processor2 processor2;

    @Autowired
    private Handler1 handler1;

    @Autowired
    private Handler2 handler2;


    @GetMapping("/biz1")
    public void biz1() {

        LinkedList<BaseHandler> handlers = new LinkedList();
        handlers.add(handler1);
        handlers.add(handler2);

        BetaProcessor betaProcessor = betaProcessor();
        betaProcessor.configurate(processor1, processor2, handlers);
        betaProcessor.process();

    }

    @Autowired
    private Processor3 processor3;

    @Autowired
    private Processor4 processor4;

    @Autowired
    private Handler3 handler3;

    @Autowired
    private Handler4 handler4;


    @GetMapping("/biz2")
    public void biz2() {

        LinkedList<BaseHandler> handlers = new LinkedList();
        handlers.add(handler3);
        handlers.add(handler4);
        BetaProcessor betaProcessor = betaProcessor();
        betaProcessor.configurate(processor3, processor4, handlers);
        betaProcessor.process();

    }

}

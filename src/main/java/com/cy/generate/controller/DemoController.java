package com.cy.generate.controller;


import com.cy.generate.common.exception.CommonException;
import com.cy.generate.domain.DemoObject;
import com.cy.generate.service.DemoService;
import com.cy.generate.support.beta.BaseProcessor;
import com.cy.generate.support.holder.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 23:23
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private ContextHolder contextHolder;

    @GetMapping("/test")
    public DemoObject test() {
        return demoService.test();
    }


    @Resource(name = "processor1")
    private BaseProcessor baseProcessor;

    @GetMapping("/biz1")
    public void biz1() {
        try {
            contextHolder.bindRequest("request2");
            baseProcessor.getProcessor().process();
            System.out.println(contextHolder.getResponse());
        } catch (CommonException e) {
            e.printStackTrace();
            System.out.println(contextHolder.getResponse());
        } finally {
            contextHolder.clear();
        }

    }

}

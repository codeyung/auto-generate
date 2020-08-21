package com.cy.generate.controller;


import com.cy.generate.domain.DemoObject;
import com.cy.generate.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

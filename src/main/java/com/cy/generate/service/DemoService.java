package com.cy.generate.service;

import com.cy.generate.domain.DemoObject;
import com.cy.generate.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/17 23:04
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public DemoObject test() {
        return demoMapper.test();
    }

}

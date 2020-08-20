package com.cy.generate.thread;

import com.cy.generate.support.holder.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/20 12:23
 */
@Service
public class ThreadA {
    @Autowired
    private ContextHolder contextHolder;

    public void setValue(String value) {
        System.out.println("ThreadA setValue : " + value);
        contextHolder.bindRequest(value);
    }

    public String getValue() {
        String value = (String) contextHolder.getRequest();
        System.out.println("ThreadA getValue : value : " + value);
        return value;
    }
}

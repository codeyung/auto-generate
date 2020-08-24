package com.cy.generate.support.beta;

import com.cy.generate.support.BaseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
@Service
public class Processor2 extends BaseProcessor<BaseHandler> {

    @Autowired
    public Processor2(Handler3 handler3, Handler4 handler4) {
        this.setProcessor(this);
        this.setSuccessor(null);
        this.append(handler4);
        this.append(handler3);
    }

    @Override
    public void configurate() {
    }

    @Override
    public void process() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            BaseHandler handler = (BaseHandler) iterator.next();
            if (handler.executeFlag()) {
                handler.execute();
            }
        }
        this.processSuccessor();
    }


}
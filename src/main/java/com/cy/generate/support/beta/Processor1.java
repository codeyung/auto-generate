package com.cy.generate.support.beta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
@Service
public class Processor1 extends BaseProcessor<IHandler> {

    @Autowired
    public Processor1(BaseProcessor processor2, IHandler handler3, IHandler handler4) {
        this.setProcessor(this);
        this.setSuccessor(processor2);
        this.append(handler3);
        this.append(handler4);
    }

    @Override
    public void configurate() {
    }

    @Override
    public void process() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            IHandler handler = (IHandler) iterator.next();
            if (handler.executeFlag()) {
                handler.execute();
            }
        }
        this.processSuccessor();
    }
}
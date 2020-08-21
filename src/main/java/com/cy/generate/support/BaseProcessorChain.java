package com.cy.generate.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:处理器链
 * @Author: YongJingChuan
 * @Date: 2020/8/22 10:41
 */
public abstract class BaseProcessorChain {


    private final static Logger LOGGER = LoggerFactory.getLogger(BaseProcessorChain.class);

    private BaseProcessor[] processors;

    /**
     * 串行
     */
    protected final void execute() {
        LOGGER.debug("[BaseProcessorChain] processorChain is {} , started", this.getClass().getName());
        for (BaseProcessor processor : processors) {
            if (processor.executeFlag()) {
                processor.process();
            }
        }
        LOGGER.debug("[BaseProcessorChain] processorChain is {} , ended", this.getClass().getName());
    }

    /**
     * 并行
     */
    protected abstract void parallel();

    protected final void registProcessor(BaseProcessor... processors) {
        this.processors = processors;
    }
}

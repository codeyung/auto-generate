package com.cy.generate.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:处理器
 * @Author: YongJingChuan
 * @Date: 2020/8/22 10:33
 */
public abstract class BaseProcessor {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseProcessor.class);

    private BaseExecutor executor;

    /**
     * 处理开关是否执行
     *
     * @return
     */
    protected abstract boolean executeFlag();

    /**
     * 处理器处理方法
     *
     * @return
     */
    protected final void process() {
        LOGGER.debug("[BaseProcessor] processor is {} ", this.getClass().getName());
        executor.execute();
    }

    /**
     * 注册执行体链
     *
     * @param executor
     */
    protected final BaseProcessor registExecutor(BaseExecutor executor) {
        this.executor = executor;
        return this;
    }
}

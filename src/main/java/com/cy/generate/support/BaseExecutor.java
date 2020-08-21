package com.cy.generate.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:执行体链
 * @Author: YongJingChuan
 * @Date: 2020/8/22 10:41
 */
public abstract class BaseExecutor {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseExecutor.class);

    private BaseHandler[] handlers;

    /**
     * 串行
     */
    protected final void execute() {
        LOGGER.debug("[BaseExecutor] executor is {} , started", this.getClass().getName());
        for (BaseHandler handler : handlers) {
            LOGGER.debug("[BaseExecutor] handler is {} ", handler.getClass().getName());
            if (handler.executeFlag()) {
                handler.execute();
            }
        }
        LOGGER.debug("[BaseExecutor] executor is {} , ended", this.getClass().getName());
    }

    /**
     * 并行
     */
    protected abstract void parallel();

    /**
     * 注册
     */
    protected final void registHandlers(BaseHandler... handlers) {
        this.handlers = handlers;
    }
}

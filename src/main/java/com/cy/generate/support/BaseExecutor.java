package com.cy.generate.support;

/**
 * @Description:执行体链
 * @Author: YongJingChuan
 * @Date: 2020/8/18 10:41
 */
public abstract class BaseExecutor {

    private BaseHandler[] handlers;

    /**
     * 串行
     */
    protected final void execute() {
        System.out.println("BaseExecutor-执行");
        for (BaseHandler handler : handlers) {
            if (handler.executeFlag()) {
                handler.execute();
            }
        }
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

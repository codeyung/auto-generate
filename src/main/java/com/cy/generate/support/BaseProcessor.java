package com.cy.generate.support;

/**
 * @Description:处理器
 * @Author: YongJingChuan
 * @Date: 2020/8/18 10:33
 */
public abstract class BaseProcessor {

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

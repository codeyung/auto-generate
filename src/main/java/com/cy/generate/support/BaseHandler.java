package com.cy.generate.support;

/**
 * @Description:执行体
 * @Author: YongJingChuan
 * @Date: 2020/8/22 10:43
 */
public abstract class BaseHandler {

    /**
     * 业务开关是否执行
     *
     * @return
     */
    public abstract boolean executeFlag();

    /**
     * 模型处理方法
     *
     * @return
     */
    public abstract void execute();

}

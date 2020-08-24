package com.cy.generate.support.beta;

/**
 * @Description:执行体
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
public interface IHandler {

    /**
     * 业务开关是否执行
     *
     * @return
     */
    public boolean executeFlag();

    /**
     * 模型处理方法
     *
     * @return
     */
    public void execute();

}

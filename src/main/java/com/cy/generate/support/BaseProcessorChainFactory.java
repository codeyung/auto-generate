package com.cy.generate.support;

/**
 * @Description:流程起始类
 * @Author: YongJingChuan
 * @Date: 2020/8/22 12:24
 */
public abstract class BaseProcessorChainFactory<R, P> {

    protected P param = null;
    private BaseProcessorChain chain;

    /**
     * 绑定参数
     *
     * @param param
     * @return
     */
    public BaseProcessorChainFactory param(P param) {
        this.param = param;
        return this;
    }

    /**
     * 简单校验
     */
    protected abstract void validate(P param);


    /**
     * 执行链
     */
    public final R doChain() {
        validate(param);
        System.out.println("绑定线程请求参数");
        //绑定线程请求参数
        chain.execute();
        System.out.println("返回线程处理结果");
        return null;
        //返回线程处理结果
    }

    /**
     * 注册处理器链
     *
     * @param chain
     */
    protected final BaseProcessorChainFactory registChain(BaseProcessorChain chain) {
        this.chain = chain;
        return this;
    }
}

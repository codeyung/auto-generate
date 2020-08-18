package com.cy.generate.support;

/**
 * @Description:处理器链
 * @Author: YongJingChuan
 * @Date: 2020/8/18 10:41
 */
public abstract class BaseProcessorChain {

    private BaseProcessor[] processors;

    /**
     * 串行
     */
    protected final void execute() {
        System.out.println("BaseProcessorChain-执行");
        for (BaseProcessor processor : processors) {
            if (processor.executeFlag()) {
                System.out.println("BaseProcessor-执行");
                processor.process();
            }
        }
    }

    /**
     * 并行
     */
    protected abstract void parallel();

    protected final void registProcessor(BaseProcessor... processors) {
        this.processors = processors;
    }
}

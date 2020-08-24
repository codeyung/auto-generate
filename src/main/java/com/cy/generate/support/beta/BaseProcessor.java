package com.cy.generate.support.beta;

import com.cy.generate.support.holder.ContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description:处理器基类
 * @Author: YongJingChuan
 * @Date: 2020/8/22 13:56
 */
public abstract class BaseProcessor<T> implements IProcessor, Iterable {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseProcessor.class);
    /**
     * 线程变量
     */
    @Resource
    protected ContextHolder contextHolder;
    @Resource
    protected ApplicationContext springContext;

    private final static String TERMINATE = "terminate";

    /**
     * 当前处理器
     */
    protected IProcessor processor;

    /**
     * 后继处理器
     */
    protected IProcessor successor;

    /**
     * 持有的执行器集合
     */
    protected LinkedList<T> handlers = new LinkedList();

    public IProcessor getProcessor() {
        LOGGER.debug("[BaseProcessor] processor is {}.", processor.getClass().getName());
        return processor;
    }

    public void setProcessor(IProcessor processor) {
        this.processor = processor;
    }

    public IProcessor getSuccessor() {
        LOGGER.debug("[BaseProcessor] successor is {}.", successor.getClass().getName());
        return successor;
    }

    public void setSuccessor(IProcessor successor) {
        this.successor = successor;
    }

    public boolean hasSuccessor() {
        return null != successor;
    }

    public void processSuccessor() {
        if (isTerminated()) {
            LOGGER.debug("[BaseProcessor] terminate is stop status , it will stop all processors.");
            return;
        }
        if (!hasSuccessor()) return;
        getSuccessor().process();
    }

    public void terminate() {
        LOGGER.debug("[BaseProcessor] terminate works , it will stop all processors.");
        contextHolder.bindLocal(TERMINATE, Boolean.TRUE);
    }

    public T getHandler() {
        Assert.notEmpty(handlers, "handlers cant not be null.");
        LOGGER.debug("[BaseProcessor] handler is {}.", handlers.get(0).getClass().getName());
        return handlers.get(0);
    }

    public LinkedList<T> getHandlers() {
        return handlers;
    }

    public void setHandlers(LinkedList<T> handlers) {
        this.handlers = handlers;
    }

    protected void attach(T handler) {
        handlers.add(handler);
    }

    protected void append(T handler) {
        handlers.addLast(handler);
    }

    @Override
    public Iterator iterator() {
        return new BaseProcessorIterator();
    }

    private class BaseProcessorIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < handlers.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                LOGGER.debug("[BaseProcessor] handler is {}.", handlers.get(index).getClass().getName());
                return handlers.get(index++);
            }
            return null;
        }
    }

    private boolean isTerminated() {
        if (null == contextHolder.getLocal(TERMINATE)) return false;
        return (boolean) contextHolder.getLocal(TERMINATE);
    }
}
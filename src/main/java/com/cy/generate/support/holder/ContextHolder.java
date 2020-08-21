package com.cy.generate.support.holder;

import com.cy.generate.common.util.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:与线程绑定环境变量
 * @Author: YongJingChuan
 * @Date: 2020/8/22 15:28
 */
@Component("contextHolder")
public class ContextHolder<T, R> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContextHolder.class);
    /**
     * 入参对象
     */
    public final static String REQUEST_PARAM = "request_param";

    /**
     * 出参对象
     */
    public final static String RESPONSE_PARAM = "response_param";

    /**
     * 传值对象
     */
    public final static String TRANSMIT_PARAM = "transmit_param";

    /**
     * 线程变量
     */
    private final static ThreadLocal<Map<Object, Object>> localVariable = ThreadLocal.withInitial(() -> new HashMap());

    public void bindLocal(Object key, Object value) {
        Objects.requireNonNull(key, "key can not be null");

        Map holder = localVariable.get();

        holder.put(key, value);

        localVariable.set(holder);

        LOGGER.info("[ContextHolder] key={},value={} binded.", key, GsonUtils.toJson(value));
    }

    public Object getLocal(Object key) {
        if (CollectionUtils.isEmpty(localVariable.get())) {
            return null;
        }

        Object value = localVariable.get().get(key);

        LOGGER.info("[ContextHolder] key={},value={} getted.", key, GsonUtils.toJson(value));
        return value;
    }

    public void bindRequest(T value) {
        bindLocal(REQUEST_PARAM, value);
    }

    public T getRequest() {
        T request = (T) localVariable.get().get(REQUEST_PARAM);
        LOGGER.info("[ContextHolder] key=request_param,value={} getted.", GsonUtils.toJson(request));
        return request;
    }

    public void bindResponse(R value) {
        bindLocal(RESPONSE_PARAM, value);
    }

    public R getResponse() {
        return (R) localVariable.get().get(RESPONSE_PARAM);
    }

    public void bindTransmit(Object value) {
        bindLocal(TRANSMIT_PARAM, value);
    }

    public Object getTransmit() {
        return getLocal(TRANSMIT_PARAM);
    }

    public void clear() {
        localVariable.remove();
    }


}

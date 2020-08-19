package com.cy.generate.common.builder;

import lombok.Data;

/**
 * @Description:Redis属性文件
 * @Author: YongJingChuan
 * @Date: 2020/8/19 15:02
 */
@Data
public class RedisProperties {

    private int maxTotal;
    private int maxIdle;
    private int minIdle;
    private String appName;
    private String zkConnectionStr;
    private int zkTimeout;
    private int zkSessionTimeout;
    private String password;
    private int redisTimeOut;
    private int maxRedirections;
}

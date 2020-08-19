package com.cy.generate.common.builder;

import lombok.Data;

/**
 * @Description:数据源属性文件
 * @Author: YongJingChuan
 * @Date: 2020/8/19 14:44
 */
@Data
public class DataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String dbpoolClass;
    private String dbpoolMinimumIdle;
    private String dbpoolMaximumPoolSize;
    private String dbpoolMaxLifetime;
    private String dbpoolConnectionTimeout;
    private String dbpoolIdleTimeout;
    private String wycdsSql;
    private String wycdsJdbclog;
    private String wycdsRangeCompare;
    private String wycdsRoute2all;
    private String wycdsWycpDecoding;
}

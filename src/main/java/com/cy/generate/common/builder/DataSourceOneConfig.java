package com.cy.generate.common.builder;

/**
 * @Description:自定义数据源
 * @Author: YongJingChuan
 * @Date: 2020/8/19 19:46
 */
//@Configuration
//@MapperScan(basePackages = {"xxx.xxx.a.mapper", "xxx.xxx.mapper"}, sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSourceOneConfig {

//    @Bean(name = "dbProperties1")
//    @ConfigurationProperties(prefix = "datasource.cds.data1")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "datasource1")
//    @Primary
//    public DataSource dataSource(@Qualifier(value = "dbProperties1") DataSourceProperties dataSourceProperties) {
//        System.out.println(dataSourceProperties);
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
//        dataSource.setUrl(dataSourceProperties.getUrl());
//        Properties properties = new Properties();
//        properties.setProperty("dbpool.class", dataSourceProperties.getDbpoolClass());
//        properties.setProperty("dbpool.minIdle", dataSourceProperties.getDbpoolMinimumIdle());
//        properties.setProperty("dbpool.maximumPoolSize", dataSourceProperties.getDbpoolMaximumPoolSize());
//        properties.setProperty("dbpool.maxLifetime", dataSourceProperties.getDbpoolMaxLifetime());
//        properties.setProperty("dbpool.connectionTimeout", dataSourceProperties.getDbpoolConnectionTimeout());
//        properties.setProperty("dbpool.idleTimeout", dataSourceProperties.getDbpoolIdleTimeout());
//        properties.setProperty("wycds.sql", dataSourceProperties.getWycdsSql());
//        properties.setProperty("wycds.jdbclog", dataSourceProperties.getWycdsJdbclog());
//        properties.setProperty("wycds.range.compare", dataSourceProperties.getWycdsRangeCompare());
//        properties.setProperty("wycds.route2all", dataSourceProperties.getWycdsRoute2all());
//        properties.setProperty("wycds.wycp.decoding", dataSourceProperties.getWycdsWycpDecoding());
//        dataSource.setConnectionProperties(properties);
//        return dataSource;
//    }
//
//    @Bean(name = "globalConfig")
//    @Primary
//    public GlobalConfig globalConfig() {
//        GlobalConfig globalConfig = new GlobalConfig();
//        return globalConfig;
//    }
//
//    @Bean(name = "sessionFactory1")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "datasource1") DataSource dataSource, GlobalConfig globalConfig) throws Exception {
//        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setGlobalConfig(globalConfig());
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        // 需要在这里指定xml文件的位置，不然自定义的sql会报Invalid bound statement异常
//        List<String> mapperLocations = new ArrayList<>();
//        // 不同路径下的Mapper文件
//        mapperLocations.add("classpath:/biz/mybatis/mapper/*Mapper.xml");
//        mapperLocations.add("classpath:/mybatis/mapper/*Mapper.xml");
//        List<Resource> resources = new ArrayList();
//        if (mapperLocations != null) {
//            for (String mapperLocation : mapperLocations) {
//                try {
//                    Resource[] mappers = resolver.getResources(mapperLocation);
//                    resources.addAll(Arrays.asList(mappers));
//                } catch (IOException e) {
//                    // ignore
//                }
//            }
//        }
//        bean.setMapperLocations(resources.toArray(new Resource[resources.size()]));
//
//        // 导入mybatis配置
//        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
//        // 配置打印sql语句
//        mybatisConfiguration.setLogImpl(StdOutImpl.class);
//        bean.setConfiguration(mybatisConfiguration);
//
//        return bean.getObject();
//    }
//
//    @Bean(name = "transactionManager1")
//    @Primary
//    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("datasource1") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "sqlSessionTemplate1")
//    @Primary
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sessionFactory1") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}

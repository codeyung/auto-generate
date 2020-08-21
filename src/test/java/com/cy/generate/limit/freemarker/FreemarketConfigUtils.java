package com.cy.generate.limit.freemarker;

import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * @Description:Freemarket模板-配置类
 * @Author: YongJingChuan
 * @Date: 2020/8/22 23:56
 */
public class FreemarketConfigUtils {

    private static String path = "src/main/resources/templates/limit/";
    public final static int TYPE_BIZ = 0;
    public final static int TYPE_QUERY = 1;
    public final static int TYPE_TRADE = 2;
    public final static int TYPE_QUERY_TOOL = 3;
    private static Configuration configuration;


    public static synchronized Configuration getInstance() {
        if (null == configuration) {
            configuration = new Configuration(Configuration.VERSION_2_3_23);
            try {
                configuration.setDirectoryForTemplateLoading(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            configuration.setEncoding(Locale.CHINA, "utf-8");
        }
        return configuration;
    }

}

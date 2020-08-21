package com.cy.generate.limit.freemarker;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * @Description:模板-文件工具类
 * @Author: YongJingChuan
 * @Date: 2020/8/22 23:56
 */
public class FileUtil {

    /**
     * @param type     使用模板类型
     * @param data     填充数据
     * @param fileName 输出文件名
     * @throws IOException
     * @throws TemplateException
     */
    public static void generateToJava(String sroucePath, int type, Object data, String fileName) throws IOException, TemplateException {
        Template tpl = getTemplate(type);
        // 填充数据
        StringWriter writer = new StringWriter();
        tpl.process(data, writer);
        writer.flush();
        // 写入文件
        FileOutputStream fos = new FileOutputStream(sroucePath + fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, 1024);
        tpl.process(data, bw);
        fos.close();
    }

    /**
     * 获取模板
     *
     * @param type 模板类型
     * @return
     * @throws IOException
     */
    private static Template getTemplate(int type) throws IOException {
        switch (type) {
            case FreemarketConfigUtils.TYPE_BIZ:
                return FreemarketConfigUtils.getInstance().getTemplate("biz.ftl");
            case FreemarketConfigUtils.TYPE_QUERY:
                return FreemarketConfigUtils.getInstance().getTemplate("query.ftl");
            case FreemarketConfigUtils.TYPE_TRADE:
                return FreemarketConfigUtils.getInstance().getTemplate("biztool.ftl");
            case FreemarketConfigUtils.TYPE_QUERY_TOOL:
                return FreemarketConfigUtils.getInstance().getTemplate("querytool.ftl");
            default:
                return null;
        }
    }
}

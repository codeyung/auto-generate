//package com.cy.generate.limit;
//
//import com.cy.generate.GenerateApplication;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {GenerateApplication.class})
//public class GenerateTest {
//
//    @Autowired
//    private WaAccOwnerMapper waAccOwnerMapper;
//
//    @Autowired
//    private DemoMapper waTradeItemMapper;
//
//    @Autowired
//    private ModelNodeMapper modelNodeMapper;
//
//    @Autowired
//    private BookItemMapper bookItemMapper;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//
//    @Autowired
//    private TradeGeneratorMapper tradeGeneratorMapper;
//
//
//    private static final String OWNER = "JDD_JKJ";
//    private static final String PATH = ".request.jbp0709";
//    private static final String sroucePath = "src/main/java/com/jd/cf/asset/account/request/jbp0709/";
//
//    @Test
//    public void createBiz() throws Exception {
//        WaAccOwner owner = waAccOwnerMapper.getOwner(OWNER);
//        List<WaTradeItem> tradeList = waTradeItemMapper.getTradeItem(owner.getOwnerCode());
//        List<ModelNode> nodeList = modelNodeMapper.getModelNode(owner.getOwnerCode());
//        List<BookItem> bookList = bookItemMapper.getBookItem(owner.getOwnerCode());
//
//        String mainClassName = "BizRequestBuilder";
//        // 生成填充数据
//        Map<String, Object> entityData = new HashMap<>();
//        entityData.put("package", PATH);
//        entityData.put("author", "codeyung");
//        entityData.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        entityData.put("className", mainClassName);
//        entityData.put("owner", owner);
//        entityData.put("tradeList", tradeList);
//        entityData.put("bookList", bookList);
//        entityData.put("nodeList", nodeList);
//        entityData.put("properties", "//属性");
//        entityData.put("methods", "//方法");
//        // 生成文件
//        FileUtil.generateToJava(sroucePath, FreemarketConfigUtils.TYPE_BIZ, entityData, mainClassName + ".java");
//
//    }
//
//    @Test
//    public void createBizTool() throws Exception {
//        List<WaTradeItem> tradeList = waTradeItemMapper.getTradeItem(OWNER);
//
//        List<TradeGenerator> tradeGenerators = new ArrayList<>();
//        for (WaTradeItem trade : tradeList) {
//            TradeGenerator tradeGenerator = tradeGeneratorMapper.TradeGenerator(OWNER, trade.getTradeCode());
//            tradeGenerators.add(tradeGenerator);
//        }
//
//        System.out.println(GsonUtil.toJson(tradeGenerators));
//
//        String mainClassName = "BizTool";
//        // 生成填充数据
//        Map<String, Object> entityData = new HashMap<>();
//        entityData.put("package", PATH);
//        entityData.put("author", "codeyung");
//        entityData.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        entityData.put("className", mainClassName);
//        entityData.put("trades", tradeGenerators);
//        entityData.put("properties", "//属性");
//        entityData.put("methods", "//方法");
//        // 生成文件
//        FileUtil.generateToJava(sroucePath, FreemarketConfigUtils.TYPE_TRADE, entityData, mainClassName + ".java");
//
//    }
//
//    @Test
//    public void createBizTest() throws Exception {
//        List<WaTradeItem> tradeList = waTradeItemMapper.getTradeItem(OWNER);
//
//        List<TradeGenerator> tradeGenerators = new ArrayList<>();
//        for (WaTradeItem trade : tradeList) {
//            TradeGenerator tradeGenerator = tradeGeneratorMapper.TradeGenerator(OWNER, trade.getTradeCode());
//            tradeGenerators.add(tradeGenerator);
//        }
//
//        System.out.println(GsonUtil.toJson(tradeGenerators));
//
//        String mainClassName = "BizTest";
//        // 生成填充数据
//        Map<String, Object> entityData = new HashMap<>();
//        entityData.put("package", PATH);
//        entityData.put("author", "codeyung");
//        entityData.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        entityData.put("className", mainClassName);
//        entityData.put("trades", tradeGenerators);
//        entityData.put("properties", "//属性");
//        entityData.put("methods", "//方法");
//        // 生成文件
//        FileUtil.generateToJava(sroucePath, FreemarketConfigUtils.TYPE_BIZ_TEST_XJK, entityData, mainClassName + ".java");
//    }
//
//    @Test
//    public void createQuery() throws Exception {
//        WaAccOwner owner = waAccOwnerMapper.getOwner(OWNER);
//        List<WaTradeItem> tradeList = waTradeItemMapper.getTradeItem(owner.getOwnerCode());
//        List<ModelNode> nodeList = modelNodeMapper.getModelNode(owner.getOwnerCode());
//        List<BookItem> bookList = bookItemMapper.getBookItem(owner.getOwnerCode());
//        List<Model> modelList = modelMapper.getModel(owner.getOwnerCode());
//
//        String mainClassName = "QueryRequestBuilder";
//        // 生成填充数据
//        Map<String, Object> entityData = new HashMap<>();
//        entityData.put("package", PATH);
//        entityData.put("author", "codeyung");
//        entityData.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        entityData.put("className", mainClassName);
//        entityData.put("owner", owner);
//        entityData.put("tradeList", tradeList);
//        entityData.put("bookList", bookList);
//        entityData.put("nodeList", nodeList);
//        entityData.put("modelList", modelList);
//        entityData.put("properties", "//属性");
//        entityData.put("methods", "//方法");
//        // 生成文件
//        FileUtil.generateToJava(sroucePath, FreemarketConfigUtils.TYPE_QUERY, entityData, mainClassName + ".java");
//
//    }
//
//    @Test
//    public void createQueryTool() throws Exception {
//
//        String mainClassName = "QueryTool";
//        // 生成填充数据
//        Map<String, Object> entityData = new HashMap<>();
//        entityData.put("package", PATH);
//        entityData.put("author", "codeyung");
//        entityData.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        entityData.put("className", mainClassName);
//        entityData.put("properties", "//属性");
//        entityData.put("methods", "//方法");
//        // 生成文件
//        FileUtil.generateToJava(sroucePath, FreemarketConfigUtils.TYPE_QUERY_TOOL, entityData, mainClassName + ".java");
//
//    }
//}

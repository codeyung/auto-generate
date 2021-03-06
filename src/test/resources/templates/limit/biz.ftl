package ${package};

import .api.dto.AccTypeModelNodeEntity;
import .api.dto.BookItemEntity;
import .biz.api.request.TradeAccountRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
* Author ${author}
* Date  ${date}
*/
public class ${className}{

    ${properties}

    public ${className}(){
    }

    ${methods}


    /**
    *归属方
    **/
    public enum EmOwnerCode{

    ${owner.ownerCode?if_exists }("${owner.ownerCode?if_exists }","${owner.ownerName?if_exists }");



        private String code;
        private String desc;
        EmOwnerCode(String code,String desc){
        this.code = code;
        this.desc = desc;
        }

        public String getCode(){
        return code;
        }

        public String getDesc(){
        return desc;
        }

    }

    /**
    *交易码
    **/
    public enum EmTradeCode{

        <#list tradeList as trade>
    ${trade.tradeCode}("${trade.tradeCode}","${trade.tradeName}"),
        </#list>;

        private String code;
        private String desc;
        EmTradeCode(String code,String desc){
        this.code = code;
        this.desc = desc;
        }

        public String getCode(){
        return code;
        }

        public String getDesc(){
        return desc;
        }

    }


    /**
    *账户类型
    **/
    public enum EmBookItemCode{

        <#list bookList as book>
${book.bookCodeId}("${book.bookCode}","${book.bookName}"),
        </#list>;

        private String code;
        private String desc;
        EmBookItemCode(String code,String desc){
        this.code = code;
        this.desc = desc;
        }

        public String getCode(){
        return code;
        }

        public String getDesc(){
        return desc;
        }

    }


    /**
    *账户识别ID类型（例如「小金库专户号」、「基金产品编号」、「卡ID」等）
    **/
    public enum EmNodeIdCode{

        <#list nodeList as node>
${node.nodeCode}("${node.nodeCode}","${node.nodeName}"),
        </#list>;

        private String code;
        private String desc;
        EmNodeIdCode(String code,String desc){
        this.code = code;
        this.desc = desc;
        }

        public String getCode(){
        return code;
        }

        public String getDesc(){
        return desc;
        }

    }



    /**
    * 设置账户标识
    *
    * @param models
    * @param modelNodeCode
    * @param modelNodeValue
    */
    public static void setModels(Set<AccTypeModelNodeEntity> models, String modelNodeCode, String modelNodeValue) {
        AccTypeModelNodeEntity modelNode1 = new AccTypeModelNodeEntity();
        modelNode1.setModelNodeCode(modelNodeCode);
        modelNode1.setModelNodeValue(modelNodeValue);
        models.add(modelNode1);
    }

    /**
    * 添加记账项目
    *
    * @param request
    * @param bookItemCode
    * @param tradeAmount
    * @param models
    */
    public static void setBookItemEntities(TradeAccountRequest request, String bookItemCode, BigDecimal tradeAmount, Set<AccTypeModelNodeEntity> models) {
        BookItemEntity bookItem = new BookItemEntity();
        bookItem.setBookItemCode(bookItemCode);
        bookItem.setTradeAmount(tradeAmount);
        bookItem.setModelNodeEntities(models);

        request.getBookItemEntities().add(bookItem);

        }

        /**
        * 设置切分键
        *
        * @param request
        * @param modelNodeCode
        * @param skNodeValue
        */
        public static void setSkNode(TradeAccountRequest request, String modelNodeCode, String skNodeValue) {
        AccTypeModelNodeEntity skNode = new AccTypeModelNodeEntity();
        skNode.setModelNodeCode(modelNodeCode);
        skNode.setModelNodeValue(skNodeValue);
        skNode.setSkFlag(true);
        request.setSkModelNodeEntity(skNode);
        }

        /**
        * 设置锁模型
        * @param request
        * @param modelNodeCode
        * @param modelNodeValue
        */
        public static void setLockModelNodeEntities(TradeAccountRequest request,String modelNodeCode,String modelNodeValue){
        AccTypeModelNodeEntity modelNode1 = new AccTypeModelNodeEntity();
        modelNode1.setModelNodeCode(modelNodeCode);
        modelNode1.setModelNodeValue(modelNodeValue);
        request.getLockModelNodeEntities().add(modelNode1);
        }


}


<#--1. freemarker获取list的size ：-->


<#--${list?size}-->


<#--2. list的遍历：-->


<#--<#list animals as being>-->

<#--<tr>-->

<#--<td>${being.name}${being.price}-->
<#--<td>-->

<#--</tr>-->

<#--</#list>-->


<#--3. 遍历MAP-->


<#--<#list map?keys as k>-->

<#--<option value="${k}">${map[k]}</option>-->

<#--</#list>-->


<#--4.list遍历中的下标序号：-->


<#--_index是list的一个属性-->

<#--<#list list as a>-->

<#--${a_index}-->

<#--</#list>-->


<#--5.取LIST中第i个元素的值-->

<#--${list[i]}-->

<#--嵌套时前面要有括号，如下，将字符串变成list，然后取第i个元素的值-->

<#--${(str?split(","))[i]}-->


<#--6. list的嵌套：-->

<#--<#list jsskList as jsskVO>-->

<#--<#list kcList as kcVO>-->

<#--<#if kcVO.kch=jsskVO.kch> （kcVO里有编号和名称，而jsskVO里只有编号）-->

<#--${kcVO.kcm}-->

<#--</#if>-->

<#--</#list>-->

<#--</#list>-->


<#--7. list排序：-->

<#--升序 .sort_by()-->

<#--<#list list?sort_by("字段") as x>-->

<#--</#list>-->


<#--降序 .sort_by()?reverse-->

<#--<#list list?sort_by("字段")?reverse as x>-->

<#--</#list>-->

<#--8.item_has_next,size使用：-->


<#--<#list userList as user>-->


<#--<#if !user_has_next>-->
<#--共有${userList?size}最后一个用户是:${user.userName}-->
<#--</#if>-->
<#--</#list>-->
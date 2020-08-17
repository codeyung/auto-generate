package ${package};

import .api.dto.AccTypeModelNodeEntity;
import .api.dto.BookItemEntity;
import .biz.api.request.TradeAccountRequest;

import java.math.BigDecimal;
import java.util.*;

/**
* Author ${author}
* Date  ${date}
*/
public class ${className}{

    ${properties}

    public ${className}(){
    }

    ${methods}

<#list trades as trade>
//${trade.tradeName}
public void ${trade.tradeCode}(){
    TradeAccountRequest request = new TradeAccountRequest();
    // 交易信息包装 ------start
    request.setSysId("");//调用方系统应用id
    request.setOwnerCode(BizRequestBuilder.EmOwnerCode.${trade.ownerCode}.getCode());
    request.setTradeCode(BizRequestBuilder.EmTradeCode.${trade.tradeCode}.getCode());
    request.setUserId(null);//非必填 pin cust_no

    //// 1.交易请求及交易核心信息
    request.setReqTime(new Date());//发起请求的当前时间
    request.setReqOrderNo("");//请求订单号，唯一性，账务系统做防重/幂等用途，注：须日期戳（年月）前缀
    request.setFrontTradeNo("");//前端订单号（用作关联）
    request.setFontTradeDate(null);//前端交易时间（业务发生时间）
    request.setFrontBizCode("");//前端业务类码(便于后期统计，可以不传)
    request.setFrontBizRemark("");//前端业务描述
    request.setFrontSubBizCode("");//前端二级业务类码
    request.setFrontSubBizRemark("");//前端二级业务描述
    //        request.setMainTradeAmount1();//主交易金额1（优先用作资金流金额）
    //        request.setMainTradeAmount2();//主交易金额2
    //        request.setRemarks("");//信息备注,备用字段
    //        request.setNotes("");//注解备注,备用字段

    //// 2.资金对账相关，代收付场景可使用
    //        request.setPayOrderNo("");//支付订单号（用作与支付关联）
    //        request.setMerchantOrderNo("");//前端商户订单号（用作与支付关联对账）
    //        request.setMhtCustomerId("");//商户会员ID
    //        request.getMhtNo("");//商户号
    //        request.setMhtAccNo("");//商户账户号
    //        request.setPayChannel("");//支付渠道（区分代收付渠道方式）

    //// 3.交易备用字段，按需要使用
    //        request.setRequestExtParam(null);//请求扩展域
    //        request.setBizChannel("");//业务渠道
    //        request.setLinkSource("");//链接来源
    //        request.setCertificateNo("");//

    // 切分键值
    BizRequestBuilder.setSkNode(request, BizRequestBuilder.EmNodeIdCode.${trade.sk}.getCode(), "");

    <#if trade.lockIdValues ??>
    // 防并发锁值
    Set<AccTypeModelNodeEntity> lockModelNodeEntities = new HashSet<AccTypeModelNodeEntity>();
    request.setLockModelNodeEntities(lockModelNodeEntities);
    <#list trade.lockIdValues?split(">") as idValue>
    BizRequestBuilder.setLockModelNodeEntities(request, BizRequestBuilder.EmNodeIdCode.${idValue}.getCode(), "");
    </#list>
    </#if>
    // 交易信息包装 ------end

    // 记账信息包装 ------start
    List<BookItemEntity> bookItemEntities = new ArrayList<BookItemEntity>();
    request.setBookItemEntities(bookItemEntities);
    <#list trade.cells as cell>
    //账户：${cell.cellName} | 加减符号：${cell.symbol} | 自动开户：${cell.autoOpen} | 金额规则：${cell.amtRule} | 账户类型数量：${cell.cellNum} | 账户余额列名：${cell.balanceColumn}
    Set<AccTypeModelNodeEntity> idValues${cell_index} = new HashSet<>();
    <#list cell.idValues?split(">") as idValue>
    BizRequestBuilder.setModels(idValues${cell_index}, BizRequestBuilder.EmNodeIdCode.${idValue}.getCode(), "");
    </#list>
    BizRequestBuilder.setBookItemEntities(request, BizRequestBuilder.EmBookItemCode.${cell.cell}.getCode(), new BigDecimal(""), idValues${cell_index});
    </#list>
    // 记账信息包装 ------end

    //ResponseBase<TradeAccountResponse> account = assetFacade.account(request);

<#--    {"ownerCode":"JDD_WEALTH_XJK","tradeCode":"JW_XJK_IN",-->
<#--    "tradeName":"转入(单产品单卡)","sk":"JW_XJK",-->
<#--    "lockIdValues":"JW_XJK",-->
<#--    "cells":[-->
<#--    {"cell":"AC_SUB_JW0101_JW_X_PRODUCT","cellNum":"equalOrGreaterThanOne","idValues":"JW_XJK>JW_XJK_PRODUCT"},-->
<#--    {"cell":"AC_SUB_JW0102_JW_X_PRODUCT","cellNum":"equalOrGreaterThanOne","idValues":"JW_XJK>JW_XJK_PRODUCT"}]}-->
 }

 </#list>

}
<#--是否存在-->
<#--<#if trade.lockIdValues?if_exists>-->
<#--切分字符-->
<#--<#list cell.lockIdValues?split(">") as idValue>-->

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
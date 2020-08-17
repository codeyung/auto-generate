package ${package};

import .api.dto.AccTypeModelNodeEntity;
import .query.api.request.QuerySubAccountRequest;

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
                    
    //子账户查询
    public void querySubAccount() {
        QuerySubAccountRequest request = new QuerySubAccountRequest();
        request.setReqTime(new Date());
        request.setSysId("");//调用方系统应用id
        request.setOwnerCode(null);//设置归属方 QueryRequestBuilder.EmOwnerCode
        request.setParentModelCode(null);//设置父账户结构 QueryRequestBuilder.EmModelType

        List<AccTypeModelNodeEntity> idValues0 = new ArrayList<AccTypeModelNodeEntity>(); //  账户idValue
        //QueryRequestBuilder.EmNodeIdCode 账户对应id， true 为切分建其它为 false
        QueryRequestBuilder.setModels(idValues0, null,"", true);
        QueryRequestBuilder.setModels(idValues0, null, "", false);

        QueryRequestBuilder.setParentlistEntities(request, idValues0);//设置父账户类型


        List<String> accCellCodes = new ArrayList<String>();
        request.setAccCellCodes(accCellCodes);
        //查询子账户的账户类型 QueryRequestBuilder.EmBookItemCode
        QueryRequestBuilder.setAccCellCode(request, null);
        QueryRequestBuilder.setAccCellCode(request, null);
        QueryRequestBuilder.setAccCellCode(request, null);

//      ResponseBase<QuerySubAccountResponse> response = waAccountQueryTradeFacade.querySubAccount(request);
//      System.out.println("出参：" + GsonUtil.toJson(response));

    }

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
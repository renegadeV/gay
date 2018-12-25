<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
td {
 text-align: center;
} 
p{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:30%;
top:50%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>查询结果</h1>
<s:if test="moneyCard==null">
<p>没有查询到该卡号</p>
</s:if>
<s:else>
<table class="Table">
<tr>
<th>充值卡号</th><th>密码</th><th>金额</th><th>使用者</th><th>是否使用</th>
</tr>
<tr>
<td><s:property value="moneyCard.moneyCardID"/></td>
<td><s:property value="moneyCard.password"/></td>
<td><s:property value="moneyCard.money"/></td>
<s:if test="moneyCard.customerID==0">
<td>
无
</td>
<td>
未使用
</td>
</s:if>
<s:else>
<td>
<s:a href="AdminShowCustomer.action?customer.customerID=%{moneyCard.customerID}"><s:property value="customer.name"/></s:a>
</td>
<td>
已使用
</td>
</s:else>
</tr>
</table>
</s:else>
<s:a href="AdminFindMoneyCard.jsp">返回</s:a>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.table{
	position:absolute;
	left:0%;
	top:10%;
	width:100%;
	height:10%;
	border-style:solid;
	border-width:1px;
}
td {
	text-align: center;
}
.orders{
position:absolute;
	left:0%;
	top:20%;
	width:100%;
	height:80%;
	border-style:solid;
	border-width:1px;
}
</style>
<link rel="stylesheet" type="text/css" href="AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<s:actionerror class="actionMessage"/>
<div class="AdminDoBox">
<h1>用户资料</h1>
<br>
<table  class="table">
<tr><th>用户ID:</th><th>用户名:</th><th>密码:</th><th>性别:</th><th>联系电话:</th>
<th>电子邮件:</th><th>累计消费</th><th>累计充值</th><th>账户余额</th></tr>
<tr>
<td><s:property value="customer.customerID"/></td>
<td><s:property value="customer.account"/></td>
<td><s:property value="customer.password"/></td>
<td><s:property value="customer.sex"/></td>
<td><s:property value="customer.phone"/></td>
<td><s:property value="customer.email"/></td>
<td><s:property value="customer.usedMoney"/></td>
<td><s:property value="customer.inMoney"/></td>
<td><s:property value="customer.money"/></td>
<td><s:a href="AdminDeleteCustomer.action?customer.customerID=%{customer.customerID}" onclick="return confirm('你确定要删除该记录吗？');">删除</s:a></td>
<td><s:a href="AdminUpdateCustomer.action?customer.customerID=%{customer.customerID}" >修改</s:a></td>
</tr>
</table>
<div class="orders">
<s:include value="AdminShowCustomerOrder.jsp"/>
</div>
</div>
</body>
</html>
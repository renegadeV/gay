<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.p{
color:red;
font-size:1.5em;
font-weight:600;
position:absolute;
left:20%;
top:20%;
}
.url{
font-size:1.5em;
font-weight:600;
position:absolute;
left:30%;
top:27%;
}
table{
top:10%;
position:absolute;
width:100%;
font-size:1.5em;
}
td {
	text-align: center;
}
</style>
<link rel="stylesheet" type="text/css" href="style/UserStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地址管理</title>
</head>
<body style="background-color:#FFF0F5">
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle1">
<h1 >我的收货地址</h1>
<ul>
<li><p style="font-size:1.2em; right:1px;"><s:a href="addAddress.jsp">新建收货地址</s:a></p></li>
</ul>
</div>
<s:actionmessage class="PageMessage"/>
<div class="UserShowBox">
<s:if test="#session['loginUser'].address.size==0">
<p class="p">你还没有任何收货地址，请添加！</p>
<p class="url"><s:a href="addAddress.jsp">添加收货地址</s:a></p>
</s:if>
<s:else>
<table>
<tr>
<th>收件人</th><th>手机号码</th><th>收件地址</th><th>邮政编码</th><th colspan="2">操作</th>
</tr>
<s:iterator value="#session['loginUser'].address">
<tr>
<td><s:property value="name"/></td>
<td><s:property value="phone"/></td>
<td><s:property value="address"/></td>
<td><s:property value="zipcode"/></td>
<td><s:a href="UpdateAddress.jsp?id=%{addressID}" >修改</s:a></td>
<td><s:a href="deleteAddress.action?address.addressID=%{addressID}" >删除</s:a>
</tr>
</s:iterator>
</table>
</s:else>
</div>
</div>
</body>
</html>
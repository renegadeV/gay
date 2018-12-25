<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
p{
font-size:1.5em;
position:absolute;
left:10%;
top:30%;
}
.input{
position:absolute;
top:32%;
width:25%;
height:6.5%;
left:32%;
}
.button{
position:absolute;
	background-color:transparent;
	border:solid;
	border-width:1px;
	border-color:gray;
	font-size:0.6em;
	width:10%;
	height:7%;
	top:32.5%;
	left:62%
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单处理</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>订单处理</h1>
<s:actionerror class="actionMessage;"/>
<s:actionmessage class="actionMessage"/>
<s:form action="AdminDealOrder.action" method="post">
<p>请输入快递单号:</p><s:hidden name="order.orderID" value="%{#parameters.id}"/>
<s:textfield name="order.kdNum"  class="input"/>
<s:submit value="确定" class="button"/>
</s:form>
</div>
</body>
</html>
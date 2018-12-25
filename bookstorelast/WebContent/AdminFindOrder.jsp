<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
p{
font-size:1.2em;
position:absolute;
left:10%;
}
.input{
position:absolute;
top:30%;
width:25%;
height:40%;
left:38%;
}
.button{
position:absolute;
	background-color:transparent;
	border:solid;
	border-width:1px;
	border-color:gray;
	font-size:0.6em;
	width:10%;
	height:50%;
	top:30%;
	left:65%
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
<s:form action="findOrder.action" method="post" class="xx">
<p>请输入需要查询的订单编号:</p><s:textfield name="order.orderID" class="input"/>
<s:submit value="查询订单" class="button"/>  
</s:form>
</body>
</html>
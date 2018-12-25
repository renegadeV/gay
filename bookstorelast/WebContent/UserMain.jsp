<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

</style>
<link rel="stylesheet" type="text/css" href="style/UserStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="MainBox">
<div class="MainLabelBox" style="background:url(./picture/1.jpg)">
	<h1>网上书店系统</h1>
</div>
<div class="MenuLabel" style="background:-webkit-gradient(linear, left top,left bottom, from(#FF4400), to(#27408B);">
<div class="LoginMenu" style="background:-webkit-gradient(linear, left top,left bottom, from(#FAFAFA), to(#27408B);">
<s:if test="#session['loginUser']==null">
<div>
用户未登录   <div style="position:absolute;left:30%;margin:0px;top:10%;">请 <a href="login.jsp">登陆</a>|<s:a href="getBookList.action">首页</s:a>|<a href="register.jsp">免费注册</a>|<s:a href="ShowCart.action">查看购物车</s:a></div>
</div>
</s:if>
<s:else>
<p style="position:absolute;left:-430px;margin:0;">用户已登录</p>
<p style="position:absolute;left:-280px;margin:0;"><s:property value="#session['loginUser'].name"/>你好!</p>
<div style="position:absolute;left:100px;margin:0px;"><s:a href="getBookList.action">首页</s:a>|<s:a href="logout.action">退出登录</s:a>|
<s:a href="ManageAddress.jsp">收货地址管理</s:a>|<s:a href="ShowOrder.action">订单管理</s:a>|<s:a href="ShowCart.action">查看购物车</s:a>|<s:a href="MoneyManage.jsp">账户余额</s:a>
 </div>
</s:else>
 </div>
</div>
</div>
</body>
</html>
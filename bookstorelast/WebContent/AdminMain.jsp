<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
</head>
<body style="background-color:#FFF0F5">
<div class="adminBox" style="background-color:#FFEFDB; height:1000px;">
<div class="mainLabel" style="background:url(./picture/1.jpg);color:white;height:118px;">
<h1 >网上书店系统</h1>
</div>
<s:if test="#session['admin']==null">
管理员未登录，请<s:a href="Adminlogin.jsp">登录</s:a>
</s:if>
<s:else>
<div class="adminMenu" style="top:118px;height:882px;">
<br>
<strong>管理员已登录</strong><br>
<s:a href="AdminLogout.action">注销登陆</s:a>

<s:include value="AdminMenu.jsp"></s:include>
</div>
</s:else>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理员登陆</title>
</head>
<body   style="background:-webkit-gradient(linear, left top,left bottom, from(#4169E1), to(#00EEEE));height:780px;">
<div style="position:absolute;right:30px;font-size:1.3em;color:gray;">
<s:a href="login.jsp">用户登陆</s:a>|<s:a href="getBookList.action" >首页</s:a>
</div>
<s:actionmessage class="actionmessage"/>
<div class="loginbox">
<h1 style="left:180px;">系统管理员登陆</h1>

<s:form action="SysAdminLogin.action" method="post">
<p style="position:absolute;top:83px;">管理员账号:</p><s:textfield name="sysadmin.account" class="textfield" style="position:absolute;top:110px;left:235px;"/>
<p style="position:absolute;top:40%;">管理员密码:</p><s:password name="sysadmin.password" class="textfield" style="position:absolute;top:188px;left:235px;"/>
<s:submit value="登陆" class="button" style="position:absolute;left:420px;top:270px;"/>
</s:form>
</div>
</body>
</html>
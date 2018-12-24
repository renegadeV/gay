<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body style="background:-webkit-gradient(linear, left top,left bottom, from(#4169E1), to(#00EEEE));height:780px;">
<div style="position:absolute;right:30px;font-size:1.3em;color:gray;">
<s:a href="Adminlogin.jsp">书城管理员入口</s:a>|<s:a href="SysAdminlogin.jsp">系统管理员入口</s:a>|<s:a href="getBookList.action" >首页</s:a>
</div>
<s:actionmessage class="actionmessage"/>
<s:fielderror class="fielderror"/>
<div class="loginbox">
<h1>用户登录</h1>
<s:form action="login.action" method="post">
<p style="position:absolute;top:89px;left:125px;">用户名:</p><input type="text" name="account" class="textfield" style="position:absolute;top:28%;left:42%;" />
<p style="position:absolute;top:146px;left:125px;">密&nbsp;&nbsp;&nbsp;码:</p><input type="password" name="password" class="textfield" style="position:absolute;top:43%;left:42%;"/>
<s:reset value="重置" class="button" style="position:absolute;left:140px;"/>
<s:submit value="登陆" class="button" style="position:absolute;left:340px;"/>
</s:form>
<p style="position:absolute;top:300px;left:250px;width:275px;">没有账号？请免费<s:a href="register.jsp">注册</s:a></p>
</div>
</body>
</html>
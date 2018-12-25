<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body style="background:-webkit-gradient(linear, left top,left bottom, from(#4169E1), to(#00EEEE));height:780px;">
<div style="position:absolute;right:30px;font-size:1.3em;color:gray;">
<s:a href="login.jsp">用户登陆</s:a>|<s:a href="getBookList.action">首页</s:a>
</div>
<s:fielderror class="fielderror" style="position:absolute;top:30%;"/>
<div class="registerBox">
<h1>用户注册</h1>
<s:form action="register.action" method="post">
<p>请输入用户名(3~20长度):</p><input type="text" name="customer.account" class="registerText" style="position:absolute;top:95px;"/>
<p>请输入密码(3~20长度):</p><input type="password" name="customer.password" class="registerText" style="position:absolute;top:145px;"/>
<p>请再次输入密码：</p><input type="password" name="password" class="registerText" style="position:absolute;top:197px;"/>
<p>请输入真实姓名(20长度):</p><input type="text" name="customer.name" class="registerText" style="position:absolute;top:252px;"/>
<p>请选择性别：</p><s:radio name="customer.sex"  list="#{'男':'男','女':'女' }" listkey="key" value="'男'" listvalue="value" class="radio"/>
<p>请输入手机号码:</p><input type="text" name="customer.phone" class="registerText" style="position:absolute;top:355px;"/>
<p>请输入电子邮箱:</p><input type="text" name="customer.email" class="registerText" style="position:absolute;top:408px;"/>
<s:submit value="注册" class="button" style="position:absolute;top:453px;right:50px;width:90px;"/>
</s:form>
</div>
</body>
</html>
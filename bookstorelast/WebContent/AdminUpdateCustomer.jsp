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
<body style="background:url(./picture/2.jpg)">
	<div style="position:absolute;right:30px;font-size:1.3em;color:white;">
		<s:a href="login.jsp">用户登录</s:a>|<s:a href="getBookList.action">首页</s:a>
	</div>
	<s:fielderror class="fielderror" style="position:absolute;top:30%;"/>
	<div class="registerBox">
		<h1 style="color:white;">用户注册</h1>
		<form action="AdminUpdateandSaveCustomer.action" method="post">
			<p class="P" style="position:absolute;top:80px;color:white;">ID:</p><s:textfield name="customer.customerID" class="textfield" style="position:absolute;top:100px;background:none;outline:none;border: rgba(255,255,255,0.2) 2px solid !important;border-radius: 50px;text-align:center;text-color:white;"/>
			<p class="P" style="position:absolute;top:120px;color:white;">用户名:</p><s:textfield name="customer.account" class="textfield" style="position:absolute;top:140px;background:none;outline:none;border: rgba(255,255,255,0.2) 2px solid !important;border-radius: 50px;text-align:center;text-color:white;"/>
			<p class="P" style="position:absolute;top:160px;color:white;">密码:</p><s:textfield name="customer.password" class="textfield" style="position:absolute;top:180px;background:none;outline:none;border: rgba(255,255,255,0.2) 2px solid !important;border-radius: 50px;text-align:center;text-color:white;"/>
			<p class="P" style="position:absolute;top:200px;color:white;">真实姓名:</p><s:textfield name="customer.name" class="textfield" style="position:absolute;top:220px;background:none;outline:none;border: rgba(255,255,255,0.2) 2px solid !important;border-radius: 50px;text-align:center;text-color:white;"/>
			<p style="color:gray;top:240px"">请选择性别：</p><s:radio name="customer.sex"  list="#{'男':'男','女':'女' }" listkey="key" value="'男'" listvalue="value" class="radio" style="left:300px;top:190px"/>
			<p class="P" style="position:absolute;top:280px;color:white;">电话号码:</p><s:textfield name="customer.phone" class="textfield" style="position:absolute;top:300px;background:none;outline:none;border: rgba(255,255,255,0.2) 2px solid !important;border-radius: 50px;text-align:center;text-color:white;"/>
			<p class="P" style="position:absolute;top:320px;color:white;">邮件地址:</p><s:textfield name="customer.email"  class="textfield" style="position:absolute;top:340px;background:none;outline:none;border: rgba(255,255,255,0.2) 2px solid !important;border-radius: 50px;text-align:center;text-color:white;"/>
			<s:submit value="修改并保存" class="button" style="background: #0096e6;border-radius: 50px;color:white;border:none;width:130px;"/>
		</form>
	</div>
</body>
</html>
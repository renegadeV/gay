<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.p{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:20%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户余额管理</title>
</head>
<body style="background-color:#FFF0F5">
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>账户余额</h1>
<ul>
<li  style="font-size:1.2em;"><s:a href="recharge.jsp">账户充值</s:a>
</ul>
</div>
<div class="UserShowBox">
<p class="p">当前余额:<s:property value="#session['loginUser'].money"/></p>
</div>
</div>
</body>
</html>
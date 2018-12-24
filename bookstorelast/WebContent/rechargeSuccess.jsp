<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.p{
color:black;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:10%;
}
.p1{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:17%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值成功</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>充值成功</h1>
</div>
<div class="UserShowBox">
<p class="p">已成功充值<s:property value="MoneyCard.money"/>元</p>
<p class="p1">当前账户余额:<s:property value="#session['loginUser'].money"/></p>
</div>
</div>
</body>
</html>
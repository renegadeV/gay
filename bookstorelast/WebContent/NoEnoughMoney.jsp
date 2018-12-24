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
<title>余额不足</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>购买失败</h1>
</div>
<div class="UserShowBox">
<p class="p">余额不足！购买失败！请<s:a href="recharge.jsp">充值。</s:a> </p> 
</div>
</div>

</body>
</html>
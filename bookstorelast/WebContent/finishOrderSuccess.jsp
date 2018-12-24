<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.p{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:20%;
}
.p1{
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:27%;
}
}
</style>
<title>确认收货成功</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>确认收货</h1>
</div>
<div class="UserShowBox">
<P class="p">确认收货成功！</P>
<br>
<p class="p1">可到<s:a href="ShowOrder.action?order.orderState=4">交易完成订单</s:a>中查看</p>
</div>
</div>
</body>
</html>
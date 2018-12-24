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
<title>待支付订单</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>订单管理</h1>
<ul>
<li style="font-size:1.2em;font-weight:600;">待支付订单
<li style="font-size:1.2em;"><s:a href="ShowOrder.action?order.orderState=2">待发货订单</s:a>
<li style="font-size:1.2em;"><s:a href="ShowOrder.action?order.orderState=3">待收货订单</s:a>
<li style="font-size:1.2em;"><s:a href="ShowOrder.action?order.orderState=4">已完成订单</s:a>
</ul>
</div>
<div class="UserShowBox">
<s:if test="orders.size==0">
<p class="p">你没有待支付的订单!</p>
</s:if>
<s:else>
<table border=1 class="OrderTable">
<tr>
<th>订单号</th><th>订单内容</th><th>总价</th><th>配送地址</th><th colspan=2 >操作</th>
</tr>
<s:iterator value="orders">
<tr>
<td><s:property value="orderID"/></td>
<td>
<s:iterator value="orderItem">
<s:a href="ShowBook.action?book.bookID=%{book.bookID}"><s:property value="bookTitle"/></s:a> <s:property value="bookPrice"/> *<s:property value="num"/>
<br>
</s:iterator>
</td>
<td>
<s:if test="finalPrice==price">
<s:property value="finalPrice"/><br>
<s:property value="discountName"/>
</s:if>
<s:else>
<del><s:property value="price"/></del><br>
<s:property value="finalPrice"/><br>
<s:property value="discountName"/>
</s:else>
</td>
<td>
收件人:<s:property value="name"/><br>
联系电话:<s:property value="phone"/><br>
地址:<s:property value="address"/><br>
邮编:<s:property value="zipcode"/>
</td>
<td>
<s:a href="PayOrder.action?order.orderID=%{orderID}">支付</s:a>
</td>
<td>
<s:a href="DelOrder.action?order.orderID=%{orderID}">取消</s:a>
</td>
</tr>
</s:iterator>
</table>
</s:else>
</div>
</div>
</body>
</html>
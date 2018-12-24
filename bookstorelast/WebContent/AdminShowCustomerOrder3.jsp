<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.url{
position:absolute;
top:5%;
width:100%;
left:20%;
font-size:1.3em;
}
p{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:20%;
}
.ordertable{
	position:absolute;
	left:0%;
	top:20%;
	width:100%;
	border-style:solid;
	border-width:1px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待支付订单</title>
</head>
<body>
<div class="url">
<s:a href="AdminShowCustomer.action?customer.customerID=%{customer.customerID}&order.orderState=1">待支付订单</s:a>|
<s:a href="AdminShowCustomer.action?customer.customerID=%{customer.customerID}&order.orderState=2">待发货订单</s:a>|
<strong>待收货订单</strong>|
<s:a href="AdminShowCustomer.action?customer.customerID=%{customer.customerID}&order.orderState=4">交易完成订单</s:a>
</div>
<s:if test="orders.size==0">

<p>该用户没有待收货的订单！</p>
</s:if>
<s:else>
<table border=1 class="ordertable">
<tr><th>订单编号</th><th>订单内容<th>原价</th><th>实际支付</th><th>优惠活动</th></tr>

<s:iterator value="orders">
<tr>
<td><s:a href="findOrder.action?order.orderID=%{orderID}"><s:property value="orderID"/></s:a></td>
<td>
<s:iterator value="orderItem">
<s:a href="adminShowBook.action?book.bookID=%{book.bookID}" ><s:property value="bookTitle"/></s:a>  <s:property value="bookPrice"/>*<s:property value="num"/>
<br>
</s:iterator>
</td>
<td>
<s:property value="price"/>
</td>
<td>
<s:property value="finalPrice"/>
</td>
<td>
<s:property value="discountName"/>
</td>
</tr>
</s:iterator>

</table>
</s:else>

</body>
</html>
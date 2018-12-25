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
left:30%;
top:50%;
}
</style>
<link rel="stylesheet" type="text/css" href="AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询结果</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>订单查询结果</h1>
<s:if test="order==null">
<p class="p">查询的订单不存在!</p>
</s:if>
<s:else>

<br>
<br>
<table border=1 class="Table">
<tr>
<th>订单号</th><th>订单内容</th><th>购买用户</th><th>配送地址</th><th>快递单号</th><th>原价</th><th>实际支付</th><th>优惠活动</th><th>订单状态</th>
</tr>
<tr>
<td><s:property value="order.orderID"/></td>
<td>
<s:iterator value="order.orderItem">
<s:a href="adminShowBook.action?book.bookID=%{book.bookID}"><s:property value="bookTitle"/></s:a> <s:property value="bookPrice"/> *<s:property value="num"/>
<br>
</s:iterator>
</td>
<td>
<s:a href="AdminShowCustomer.action?customer.customerID=%{order.customer.customerID}"><s:property value="order.customer.name"/></s:a>
</td>
<td>
收件人:<s:property value="order.name"/><br>
联系电话:<s:property value="order.phone"/><br>
地址:<s:property value="order.address"/><br>
邮编:<s:property value="order.zipcode"/>
</td>
<td>
<s:if test="order.kdNum==null">
无
</s:if>
<s:else>
<s:property value="order.kdNum"/>
</s:else>
</td>
<td>
<s:property value="order.price"/>
</td>
<td>
<s:property value="order.finalPrice"/>
</td>
<td>
<s:property value="order.discountName"/>
</td>
<td>
<s:if test="order.orderState==0">
交易完成<br>
用户已删除
</s:if>
<s:elseif test="order.orderState==1">
待付款
</s:elseif>
<s:elseif test="order.orderState==2">
待发货
</s:elseif>
<s:elseif test="order.orderState==3">
已发货<br>
待收货
</s:elseif>
<s:elseif test="order.orderState==4">
交易完成
</s:elseif>
<s:else>
订单状态异常
</s:else>
</td>
</tr>
</table>
</s:else>
</div>
</body>
</html>
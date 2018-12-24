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
top:40%;
}
</style>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已发货订单</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox" style="border-radius:5px;top:118px;">
<h1>已发货订单</h1>
<div class="test" style="top:48px;background-color:gray;">
<s:include value="AdminFindOrder.jsp"/>
</div>
<s:if test="orders.size==0||orders==null">
<p class="p">您没有已发货的订单！</p>
</s:if>
<s:else>
<h1>已发货订单</h1>
<table border=1 class="Table">
<tr>
<th>订单号</th><th>订单内容</th><th>总价</th><th>实际支付</th><th>优惠</th><th>购买用户</th><th>配送地址</th><th>快递单号</th><th>操作</th>
</tr>
<s:iterator value="orders">
<tr>
<td><s:property value="orderID"/></td>
<td>
<s:iterator value="orderItem">
<s:a href="adminShowBook.action?book.bookID=%{book.bookID}"><s:property value="bookTitle"/></s:a> <s:property value="bookPrice"/> *<s:property value="num"/>
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
<td>
<s:a href="AdminShowCustomer.action?customer.customerID=%{customer.customerID}"><s:property value="customer.name"/></s:a>
</td>
<td>
收件人:<s:property value="name"/><br>
联系电话:<s:property value="phone"/><br>
地址:<s:property value="address"/><br>
邮编:<s:property value="zipcode"/>
</td>
<td>
<s:property value="%{kdNum}"/>
</td>
<td>
<s:a href="AdminModifyKdNum.jsp?id=%{orderID}">修改快递单号</s:a>
</td>
</tr>
</s:iterator>
</table>
</s:else>
</div>
</body>
</html>
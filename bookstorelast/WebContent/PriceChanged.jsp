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
top:60%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>温馨提示</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>温馨提示</h1>
</div>
<div class="UserShowBox">
<p style="position:absolute;left:0%;top:5%;font-size:1.2em;font-weight:600;">某些商品的价格已经发生了变化，以下是新的订单价格:</p>
<table border=1 class="OrderTable" style="position:absolute;top:15%;">
<tr>
<th>订单号</th><th>订单内容</th><th>总价</th><th>配送地址</th></tr>
<tr>
<td><s:property value="order.orderID"/></td>
<td>
<s:iterator value="order.orderItem">
<s:a href="ShowBook.action?book.bookID=%{book.bookID}" ><s:property value="bookTitle"/></s:a>  <s:property value="bookPrice"/>*<s:property value="num"/>
<br>
</s:iterator>
</td>
<td>
<s:if test="order.finalPrice==order.price">
<s:property value="order.finalPrice"/>
<s:property value="order.discountName"/>
</s:if>
<s:else>
<del><s:property value="order.price"/></del><br>
<s:property value="order.finalPrice"/><br>
<s:property value="order.discountName"/>

</s:else>
<td>
收件人:<s:property value="order.name"/><br>
联系电话:<s:property value="order.phone"/><br>
地址:<s:property value="order.address"/><br>
邮编:<s:property value="order.zipcode"/>
</td>
</tr>
</table>
<p class="p">是否继续支付？<s:a href="PayOrder.action?order.orderID=%{order.orderID}">继续支付</s:a>/<s:a href="DelOrder.action?order.orderID=%{order.orderID}">取消订单</s:a></p>
</div>
</div>
</body>
</html>
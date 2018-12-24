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
top:70%;
}
.p1{
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
<h1>购物车价格发生变化</h1>
</div>
<div class="UserShowBox">
<p style="position:absolute;left:0%;top:4%;font-size:1.5em;font-weight:600;">新的价格:</p>
<table border=1 class="OrderTable" style="position:absolute;top:15%;">
<tr>
<th>ISBN</th><th>书名</th><th>作者</th><th>单价</th><th>数量</th><th>总价</th>
</tr>
<s:iterator value="#session['cart'].orderItem" >
<tr>
<td><s:property value="book.isbn"/></td>
<td><s:property value="book.title"/></td>
<td><s:property value="book.author"/></td>
<td><s:property value="book.price"/></td>
<td><s:property value="num"/></td>
<td><s:if test="finalPrice==price">
<s:property value="finalPrice"/><br>
<s:property value="discountName"/>
</s:if>
<s:else>
<del><s:property value="price"/></del><br>
<s:property value="finalPrice"/><br>
<s:property value="discountName"/>

</s:else></td>
</tr>
</s:iterator>
</table>
<p class="p1">总价:<s:property value="#session['cart'].finalPrice"/></p>
<p class="p">请选择<s:a href="pay.action">继续支付</s:a>/<s:a href="ShowCart.action">返回购物车</s:a></p>
</div>
</div>
</body>
</html>
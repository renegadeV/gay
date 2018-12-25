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
.url{
position:absolute;
top:90%;
left:85%;
background-color:white;
font-weight:600;
font-size:1.5em;
border:solid;
border-width:1px;
border-color:black;
height:5%;

}
</style>
<title>购物车</title>
</head>
<body style="background-color:#FFF0F5">
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<s:actionmessage class="PageMessage"/>
<div class="PageTitle1">
<h1>我的购物车</h1>
<ul>
<li style="font-size:1.2em;"><a href="${pageContext.request.contextPath }/deleteAllCart">清空购物车</a>
</ul>
</div>
<div class="UserShowBox">
<s:if test="#session['cart']==null">
<p class="p">购物车空空的！</p>
</s:if>
<s:elseif test="#session['cart'].orderItem.size==0">
<p class="p">购物车空空的！</p>
</s:elseif>
<s:else>
<table border=1 class="OrderTable">
<tr>
<th>ISBN</th><th>书名</th><th>作者</th><th>单价</th><th>数量</th><th>总价</th><th colspan=2>操作</th>
</tr>
<s:iterator value="#session['cart'].orderItem" >
<tr>
<td><s:property value="book.isbn"/></td>
<td><s:a href="ShowBook.action?book.bookID=%{book.bookID}"><s:property value="book.title"/></s:a></td>
<td><s:property value="book.author"/></td>
<td><s:property value="book.price"/></td>
<td><s:property value="num"/></td>
<td><s:property value="price"/></td>
<td><s:a href="deleteCart.action?book.bookID=%{book.bookID}">删除</s:a></td>
</tr>
</s:iterator>
</table>
<s:if test="#session['cart'].finalPrice==#session['cart'].price">
<p style="position:absolute;top:80%;left:80%;font-size:1.2em;color:red;font-weight:600;">合计 <s:property value="#session['cart'].finalPrice" /></p>
</s:if>
<s:else>
<p style="position:absolute;top:65%;left:80%;font-size:1.2em;color:red;font-weight:600;"><s:property value="#session['cart'].discountName"/></p>
<p style="position:absolute;top:75%;left:80%;font-size:1.0em;color:gray;font-weight:600;"> <del>原价：<s:property value="#session['cart'].price"/></del></p>
<p style="position:absolute;top:80%;left:80%;font-size:1.2em;color:red;font-weight:600;">现价: <s:property value="#session['cart'].finalPrice" /></p>
</s:else>
<s:a href="pay.jsp" class="url">结算</s:a>
</s:else>
</div>
</div>
</body>
</html>
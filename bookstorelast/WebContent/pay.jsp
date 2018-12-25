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
left:10%;
top:20%;
}
.tip{
position:absolute;
left:3%;
}
td {
	text-align: center;
}
.payButton{
position:absolute;
background-color:transparent;
left:85%;
top:92%;
height:7%;
width:10%;
font-size:1.1em;
border-style:solid;
border-width:1px;
border-color:black;
}
</style>
<title>购物车结算</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>购物车结算</h1>
</div>
<div class="UserShowBox">
<s:if test="#session['loginUser']==null">
<p class="p">你还没有登陆！请<s:a href="login.jsp">登陆</s:a>后结算！</p>
</s:if>
<s:else>
<s:if test="#session['loginUser'].address.size==0">
<p class="p">你没有收货地址，请<s:a href="addAddress.jsp">添加收货地址</s:a>后，再结算</p>
</s:if>
<s:else>
<h2 class="tip">请在下面选择一个收货地址</h2>
<s:form action="pay.action" method="post">
<table class="OrderTable" style="position:absolute;top:30%;">
<tr>
<th>收件人</th><th>手机号码</th><th>收件地址</th><th>邮政编码</th><th>选择</th>
</tr>
<s:iterator value="#session['loginUser'].address" status="status">
<tr>
<td><s:property value="name"/></td>
<td><s:property value="phone"/></td>
<td><s:property value="address"/></td>
<td><s:property value="zipcode"/></td>
<!--  <td><s:a href="pay.jsp?id=%{addressID}">选定</s:a></td>-->
<td>
<s:if test="#status.index==0">
<input type="radio" name="address.addressID" value="${addressID}" checked="checked">
</s:if>
<s:else>
<input type="radio" name="address.addressID" value="${addressID}">
</s:else>
</td>
</tr>
</s:iterator>
</table>
<p style="position:absolute;left:80%;top:80%;font-size:1.4em;font-weight:600;color:red;">支付金额:<s:property value="#session['cart'].finalPrice"/><p>
<s:submit value="确认支付" class="payButton"/>
</s:form>
</s:else>
</s:else>
</div>
</div>
</body>
</html>
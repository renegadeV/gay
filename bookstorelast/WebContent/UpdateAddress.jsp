<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/UserStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
p{
position:absolute;
left:20%;
font-size:1.5em;
}
.address{
position:absolute;
left:35%;
font-size:1.5em;
}
.button{
position:absolute;
top:55%;
left:59%;
background-color:transparent;
border-style:solid;
border-width:1px;
border-color:black;
height:8%;
width:10%;
}
</style>
<title>更新货地址</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<h1 class="PageTitle">更新收货地址</h1>
<div class="UserShowBox">
<s:actionmessage class="PageMessage"/>
<s:iterator value="#session['loginUser'].address">
<s:if test="#parameters.id[0]==addressID">
<s:form action="updateAddress.action" method="post" >
<s:hidden name="address.addressID" value="%{addressID}"/>
<s:hidden name="address.customerID" value="%{#session.loginUser.customerID}"/>
<p style="position:absolute;top:5%;">收件人:</p><s:textfield name="address.name" style="position:absolute;top:9%;" class="address"/>
<P style="position:absolute;top:15%;">联系电话:</P><s:textfield name="address.phone" style="position:absolute;top:19%;" class="address"/>
<p style="position:absolute;top:25%;">收货地址:</p><s:textfield name="address.address" style="position:absolute;top:29%;" class="address"/>
<p style="position:absolute;top:35%;">邮政编码:</p><s:textfield name="address.zipcode" style="position:absolute;top:39%;" class="address"/>
<s:submit value="确认修改" class="button"/>
</s:form>
</s:if>
</s:iterator>
</div>
</div>
</body>
</html>
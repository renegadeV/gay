<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.p{
font-size:2em;
font-weight:600;
position:absolute;
left:15%;
top:10%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户充值页面</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>用户充值</h1>
</div>
<div class="UserShowBox">
<div style="position:absolute;left:70%;">
<s:fielderror/>
</div>
<s:actionerror class="PageMessage" style="position:absolute;left:10%;font-size:1.5;color:red;"/>
<p class="p">请输入充值卡号和密码:</p>
<s:form action="recharge.action" method="post">
<p style="position:absolute;left:20%;top:30%;font-size:1.3em;">充值卡号码:</p><input type="text" name="moneyCard.moneyCardID"  style="position:absolute;top:34%;left:35%;width:150px;height:20px;" />
<p style="position:absolute;left:20%;top:40%;font-size:1.3em;">充值卡密码:</p><input type="password" name="moneyCard.password" style="position:absolute;top:44%;left:35%;width:150px;height:20px;"/>
<s:submit value="确认充值" style="position:absolute;left:43%;top:60%;width:80px;height:30px;font-size:0.8em;border-style:solid;border-width:1px;border-color:black;background-color:transparent;"/>
</s:form>
</div>
</div>
</body>
</html>
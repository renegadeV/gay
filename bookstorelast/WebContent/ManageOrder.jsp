<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
</head>
<body style="background-color:#FFF0F5">
<s:include value="loginInfo.jsp"/>
<br>
<br>
<br>
<s:actionmessage/>
<s:if test="order.orderState==1">
<s:include value="WaitChargeOrder.jsp"/>
</s:if>
<s:elseif test="order.orderState==2">
<s:include value="WaitSendOrder.jsp"/>
</s:elseif>
<s:elseif test="order.orderState==3">
<s:include value="WaitConfirmOrder.jsp"/>
</s:elseif>
<s:else>
<s:include value="FinishedOrder.jsp"/>
</s:else>
</body>
</html>
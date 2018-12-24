<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户订单</title>
</head>
<body>
<s:if test="order.orderState==1||order.orderState==null">
<s:include value="AdminShowCustomerOrder1.jsp"/>
</s:if>
<s:elseif test="order.orderState==2">
<s:include value="AdminShowCustomerOrder2.jsp"/>
</s:elseif>
<s:elseif test="order.orderState==3">
<s:include value="AdminShowCustomerOrder3.jsp"/>
</s:elseif>
<s:elseif test="order.orderState==4">
<s:include value="AdminShowCustomerOrder4.jsp"/>
</s:elseif>
</body>
</html>
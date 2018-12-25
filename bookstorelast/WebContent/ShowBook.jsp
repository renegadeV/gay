<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
</head>
<body style="background-color:#FFF0F5">
<s:if test="#session['admin']!=null">
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<s:include value="OneBook.jsp"/>
</div>
</s:if>
<s:else>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<s:include value="OneBook.jsp"/>
</div>
</s:else>


</body>
</html>
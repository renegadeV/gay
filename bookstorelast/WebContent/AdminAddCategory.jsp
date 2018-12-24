<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox" style="border-radius:5px;top:118px;">
<h1>一级分类添加</h1>
<s:actionmessage/><br>
<form action="AdminAddCategory.action" method="post">
<p class="P" style="position:absolute;top:70px;">大分类名:</p><s:textfield name="category.cname" class="textfield" style="position:absolute;top:94px;"/>
<s:submit value="添加" class="AddBookButton" style="top:94px;"/>
</form>
</div>
</body>
</html>
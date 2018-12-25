<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/AdminStyle.css"/>
<title>Insert title here</title>
</head>
<body style="background-color:#FFF0F5">
<div style="width:100%;text-align:center">
<form action="AdminSaveSecondCategory.action" method="post">
<h1 style="left:300px;">添加二级分类</h1>
二级分类名称：
<s:textfield name="categorySecond.csname" class="textfield" style="position:absolute;top:120px;left:530px;"/>
所属的一级分类：
<select name="category.cid">
<s:iterator var="c" value="cList">
<option value="<s:property value="#c.cid"/>"><s:property value="#c.cname"/></option>
</s:iterator>
</select>
<s:submit value="添加" class="AddBookButton" style="top:110px;right:120px;"/>
</form>
</div>

</body>
</html>
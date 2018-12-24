<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox" style="border-radius:5px;top:118px;">
<s:actionmessage style="position:relative;top:300px;"/>
<h1>图书列表</h1>
<div class="test" style="top:48px;background-color:gray;">
<s:include value="AdminFindBook.jsp"/>
</div>
<table border=1 class="Table">
<tr>
<th>ID</th><th>书名</th><th>作者</th><th>出版社</th><th>ISBN</th><th>图片地址</th><th>销量</th>
<th>库存</th><th>售价</th><th>描述</th><th colspan=2>操作</th>
</tr>
<s:iterator value="bookList" status="status" id="cust">
<tr>
<td><s:property value="bookID"/></td>
<td><s:property value="title"/></td>
<td><s:property value="author"/></td>
<td><s:property value="press"/></td>
<td><s:property value="isbn"/></td>
<td><s:property value="paddress"/></td>
<td><s:property value="soldNum"/></td>
<td><s:property value="stockNum"/></td>
<td><s:property value="price"/></td>
<td><s:property value="description"/>
<td><s:a href="AdminDeleteBook.action?book.bookID=%{bookID}" onclick="return confirm('你确定要删除该记录吗？');">删除</s:a></td>
<td><s:a href="AdminUpdateBook.action?book.bookID=%{bookID}" >修改</s:a></td>
</s:iterator>
</table>
</div>
</html>
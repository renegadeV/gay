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
<s:actionmessage style="position:relative;top:300px;"/>
<h1>一级分类列表</h1>
<div class="test" style="top:48px;background-color:gray;">
</div>
<table border=1 class="Table">
<tr>
<th>ID</th><th>一级分类名</th><th colspan=2>操作</th>
</tr>
<s:iterator value="categoryList" status="status" id="cust">
<tr>
<td><s:property value="cid"/></td>
<td><s:property value="cname"/></td>
<td><s:a href="AdminDeleteCategory.action?category.cid=%{cid}" onclick="return confirm('你确定要删除该记录吗？');">删除</s:a></td>
<td><s:a href="AdminUpdateCategory.action?category.cid=%{cid}" >修改</s:a></td>
</s:iterator>
</table>
</div>
</body>
</html>
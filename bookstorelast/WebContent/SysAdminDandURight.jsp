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
<s:include value="SysAdminMain.jsp"/>
<div class="AdminDoBox" style="border-radius:5px;top:118px;">
<s:actionmessage style="position:relative;top:300px;"/>
<h1>角色列表</h1>
<div class="test" style="top:48px;background-color:gray;">
</div>
<table border=1 class="Table">
<tr>
<th>ID</th><th>角色名</th><th colspan=2>操作</th>
</tr>
<s:iterator value="roleList" status="status" id="cust">
<tr>
<td><s:property value="roleID"/></td>
<td><s:property value="roleName"/></td>
<td><s:a href="SysAdminUpdateRight.action?role.roleID=%{roleID}" >修改</s:a></td>
</s:iterator>
</table>
</div>
</body>
</html>
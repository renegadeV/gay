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
<div class="AdminDoBox" style="left:383px;border-radius:5px;top:118px;">
<h1>角色添加</h1>
<s:actionmessage/><br>
<form action="SysAdminAddRole.action" method="post">
<p class="P" style="position:absolute;top:70px;">角色名:</p><s:textfield name="role.roleName" class="textfield" style="position:absolute;top:94px;"/>
<s:submit value="添加" class="AddBookButton" style="top:94px;"/>
</form>
</div>
</body>
</html>
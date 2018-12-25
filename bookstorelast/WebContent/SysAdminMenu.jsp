<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书店管理</title>
</head>
<body>
<h1>管理员菜单</h1>
<h3>角色管理</h3>
<ul>
 <li><s:a href="SysAdminAddRole.jsp">添加角色</s:a></li>
 <li><s:a href="SysAdminDandURole.action">更新和删除</s:a></li>
</ul>
<h3>权限管理</h3>
<ul>
 <li><s:a href="SysAdminDandURight.action">权限修改</s:a></li>
</ul>
</body>
</html>

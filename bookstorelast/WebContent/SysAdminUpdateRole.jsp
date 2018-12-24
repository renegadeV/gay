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
<div class="AdminDoBox">
<h1>角色更新</h1>
<form action="SysAdminUpdateandSaveRole.action" method="post">
<p class="P" style="position:absolute;top:40px;">ID:</p><s:textfield name="role.roleID"  readonly="true" class="textfield" style="position:absolute;top:60px;"/><br><br>
<p class="P" style="position:absolute;top:80px;">角色名:</p><s:textfield name="role.roleName" class="textfield" style="position:absolute;top:100px;"/>
<s:submit value="修改并保存"  class="UpdateBookButton"/>
</form>
</div>
</body>
</html>
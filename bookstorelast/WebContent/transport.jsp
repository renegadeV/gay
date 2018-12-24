<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物流查看</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<div class="PageTitle">
<h1>物流查看</h1>
</div>
<div class="UserShowBox">
<p style="font-size:1.2em;">您的快递单号:<strong><s:property value="%{#parameters.id}"/></strong>,请在下面输入快递单号：</p>
<iframe name="kuaidi100"  src="http://www.kuaidi100.com/frame/app/index.html?canvas_pos=600" width="600" height="360" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
p{
font-size:1.2em;
position:absolute;
left:0%;
}
select{
position:absolute;
height:35px;
width:80px;
left:25%;
top:20%;
font-size:1.2em;
border:solid;
border-width:2px;
}
.input{
position:absolute;
top:30%;
width:25%;
height:40%;
left:38%;
}
.button{
position:absolute;
	background-color:transparent;
	border:solid;
	border-width:1px;
	border-color:gray;
	font-size:1.1em;
	width:10%;
	height:50%;
	top:30%;
	left:65%
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
<s:form action="AdminFindBook.action" method="post" class="xx">
<p>请输入需要搜索的内容:</p>
<select name="type">
<option value="bookname">书名</option>
<option value="author">作者</option>
<option value="bookID">ID</option>
</select>
<s:textfield name="typeValue" style="position:absolute;top:20%;left:37%;width:25%;height:50%;margin:0px;font-size:1.3em;font-weight:400;"/>
<s:submit value="搜索" class="button"/>  
</s:form>
</body>
</html>
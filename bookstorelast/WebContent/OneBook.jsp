<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/UserStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="book.title"/></title>
<style type="text/css">
.pic{
position:absolute;
top:10%;
width:30%;
height:70%;
left:5%;
border:solid;
}
.Table{
position:absolute;
top:5%;
width:50%;
height:95%;
left:40%;
}
.p{
position:absolute;
left:5%;
font-size:1.3em;
}
.p1{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:20%;
}
.item{
position:absolute;
width:20%;
left:80%;
}
.Title{
position:absolute;
font-size:1.2em;
left:25%;
}
.AButton{
border:solid;
border-width:1px;
background-color:transparent;
position:absolute;
top:85%;
width:10%;
height:5%;
left:5%;
}
.DButton{
border:solid;
border-width:1px;
background-color:transparent;
position:absolute;
top:85%;
width:10%;
height:5%;
left:37%;
}
.Input{
border:solid;
border-width:1px;
background-color:transparent;
position:absolute;
top:83%;
height:6%;
width:20%;
left:16%;
}
.AddButton{
border:solid;
border-width:1px;
background-color:transparent;
position:absolute;
top:92%;
height:5%;
width:40%;
left:5%;
}
.goback{
border:solid;
border-width:1px;
background-color:transparent;
position:absolute;
top:92%;
height:5%;
width:40%;
left:50%;
}
</style>
</head>
<script type="text/javascript">
function subNum(){
	if(document.getElementById("num").value>1)
	document.getElementById("num").value--;
	}
	function addNum(){
		if(document.getElementById("num").value<=99)
	document.getElementById("num").value++;
	}
</script>
<body>
<div class="PageTitle">
<h1>图书详情</h1>
</div>
<s:actionmessage class="PageMessage"/>
<div class="UserShowBox">

<s:if test="book.stockNum==-999">
<p class="p1">该商品已下架!</p>
</s:if>
<s:else>
<img alt="无法加载图片" src="${book.paddress}" width="150" height="240" class="pic"/>
<div class="Table">
<p class="p" style="position:absolute;top:0%;">书名:</p><p class="Title" style="position:absolute;top:0%;"><s:property value="book.title" /></p>
<p class="p" style="position:absolute;top:10%;">作者:</p><p class="Title" style="position:absolute;top:10%;"><s:property value="book.author"/></p>
<p class="p" style="position:absolute;top:20%;">出版社:</p><p class="Title" style="position:absolute;top:20%;"><s:property value="book.press" /></p>
<p class="p" style="position:absolute;top:30%;">售价:</p><p class="Title" style="position:absolute;top:30%;"><s:property value="book.price"/></p>
<p class="p" style="position:absolute;top:40%;">库存:</p><p class="Title" style="position:absolute;top:40%;"><s:property value="book.stockNum" /></p>
<p class="p" style="position:absolute;top:50%;">销量:</p><p class="Title" style="position:absolute;top:50%;"><s:property value="book.soldNum" /></p>
<p class="p" style="position:absolute;top:60%;">简介:</p><p class="Title" style="position:absolute;top:60%;"><s:property value="book.description" /></p>
<s:form action="AddtoCart.action" method="post">
<s:hidden name="book.bookID" value="%{book.bookID}"></s:hidden>
<input type="button" value="-" onclick="subNum()" class="AButton"><input type="text" class="Input" name="num" id="num" value="1"><input type="button" value="+" onclick="addNum()" class="DButton">
<s:submit value="添加到购物车" class="AddButton"/>
<a class="goback" href="javascript:history.back(-1)">继续添加</a>
</s:form>
</div>
</s:else>
</div>
</body>
</html>
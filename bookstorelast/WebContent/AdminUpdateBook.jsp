<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息更新</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox" style="border-radius:5px;top:118px;">
<h1>图书更新</h1><br>
<form action="AdminUpdateandSaveBook.action" method="post">
<p class="P" style="position:absolute;top:40px;">ID:</p><s:textfield name="book.bookID"  readonly="true" class="textfield" style="position:absolute;top:60px;"/><br><br>
<p class="P" style="position:absolute;top:80px;">书名:</p><s:textfield name="book.title" class="textfield" style="position:absolute;top:100px;"/>
<p class="P" style="position:absolute;top:120px;">作者:</p><s:textfield name="book.author" class="textfield" style="position:absolute;top:140px;"/>
<p class="P" style="position:absolute;top:160px;">出版社:</p><s:textfield name="book.press" class="textfield" style="position:absolute;top:180px;"/>
<p class="P" style="position:absolute;top:200px;">ISBN:</p><s:textfield name="book.isbn" class="textfield" style="position:absolute;top:220px;"/>
<p class="P" style="position:absolute;top:240px;">图片地址:</p><s:textfield name="book.paddress" class="textfield" style="position:absolute;top:260px;"/>
<p class="P" style="position:absolute;top:280px;">销量</p><s:textfield name="book.soldNum"  class="textfield" style="position:absolute;top:300px;" readonly="true"/>
<p class="P" style="position:absolute;top:320px;">库存:</p><s:textfield name="book.stockNum"  class="textfield" style="position:absolute;top:340px;"/>
<p class="P" style="position:absolute;top:360px;">售价:</p><s:textfield name="book.price" class="textfield" style="position:absolute;top:380px;"/>
<p class="P" style="position:absolute;top:400px;">描述:</p><s:textarea name="book.description" class="textfield" style="position:absolute;top:420px;font-size:1.3em;font-weight:600;height:50px;width:300px;"/>
<select name="book.categorySecond.csid">
<s:iterator var="c" value="csList">
<option value="<s:property value="#c.csid"/>"><s:property value="#c.csname"/></option>
</s:iterator>
</select>
<s:submit value="修改并保存"  class="UpdateBookButton"/>
</form>
</div>
</body>
</html>
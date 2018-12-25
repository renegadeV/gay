<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
p{
position:absolute;
font-size:1.3em;
top:40%;
left:10%;
}
.radio{
position:relative;
font-size:1.3em;
top:125px;
left:280px;
}
.ProduceButton{

	background-color:transparent;
	border:solid;
	border-width:1px;
	border-color:gray;
	position:absolute;
	font-size:1.4em;
	width:100px;
	height:35px;
	top:33%;
	left:55%;
}
.textf{
position:absolute;
left:32%;
width:20%;
height:5%;
top:33%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生产购物卡</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox" style="border-radius:5px;top:118px;">
<h1>生产购物卡</h1>
<s:form action="produceCard.action" method="post">
<p style="position:absolute;top:20%;">请选择充值卡面额:</p><s:radio name="money" class="radio" value="50" list="#{'50':'50元','100':'100元','200':'200元','500':'500元'}"  list-value="value" list-key="key"/>
<p style="position:absolute;top:30%;">请输入生产数量:</p><s:textfield name="num" class="textf"/>
<s:submit value="确认生产" class="ProduceButton"/>
</s:form>
<s:if test="newcards!=null">
<h2 style="position:absolute;top:40%;left:10%;background-color:yellow;">刚生产的购物卡:</h2>
<table border=1 class="Table" style="postion:absolute;top:55%;width:60%;left:10%;">
<tr>
<th>卡号</th><th>卡密</th><th>金额</th>
</tr>
<s:iterator value="newcards">
<tr>
<td style="height:30px;"><s:property value="moneyCardID"/></td>
<td style="height:30px;"><s:property value="password"/></td>
<td style="height:30px;"><s:property value="money"/></td>
</tr>
</s:iterator>
</table>
</s:if>
</div>
</body>
</html>
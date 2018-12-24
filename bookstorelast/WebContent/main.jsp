<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
select{
position:absolute;
height:35px;
width:80px;
left:30%;
top:10%;
font-size:1.2em;
border:solid;
border-width:2px;
}
.button{
position:absolute;
height:33px;
width:85px;
top:15%;
left:75%;
font-size:1.2em;
border:solid;
background-color:transparent;
}
</style>
<title>网上书店</title>
</head>
<body style="background-color:#FFF0F5">
<s:include value="UserMain.jsp"/>
			<div style="margin-top:200px;margin-left:240px;position:relative;z-index:999;">
				<s:iterator var="c" value="#session.cList">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>"><s:property value="#c.cname"/></a>
							</dt>
								<s:iterator var="cs" value="#c.categorySeconds">
									<dd>
										<a href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></a>
									</dd>
								</s:iterator>	
						</dl>
				</s:iterator>		
			</div>

<div class="BookListBox">
<div class="PageTitle">
	<h1 >图书列表</h1>
</div>
<div class="BookList">
<s:actionmessage style="position:relative;top:200px;left:150px;font-size:1.5em;color:red;"/>
<div style="position:absolute;top:-45px;width:915px;height:40px;background-color:#FFC0CB;border-radius:10px;">
<form action="FindBook.action" method="post">
<p style="position:absolute;top:8px;left:10%;margin:0px;font-size:1.3em;font-weight:400;">请输入查询内容:</p>
<select name="type">
<option value="bookname">书名</option>
<option value="author">作者</option>
<option value="bookID">ID</option>
</select>
<s:textfield name="typeValue" style="position:absolute;top:10%;left:40%;width:30%;height:30px;font-size:1.2em;"/>
<s:submit value="搜索" class="button" style="color:#C2C2C2; background-color:#F5F5F5"/>
</form>
</div>

<s:iterator value="bookList" status="status" id="cust">
<s:if test="stockNum!=-999">
<div class="OneBook">
<img alt="无法加载图片" src="${paddress}"/>
<div class="BookIns">
<s:a href="ShowBook.action?book.bookID=%{bookID}"><s:property value="title"/></s:a>
<s:property value="author"/><br>
<div class="price">
售价:<s:property value="price"/>元<br>
</div>
<s:a href="AddtoCart.action?book.bookID=%{bookID}&num=1" class="AddCartButton">添加到购物车</s:a>
</div>
</div>
</s:if>
</s:iterator>

</div>
</div>
<s:if test="customer.role.rightCode%2==1">
<h3>图书管理</h3>
<ul>
 <li><s:a href="AdminAddBook.jsp">添加图书</s:a></li>
 <li><s:a href="AdminDandUBook.action">更新和删除</s:a></li>
</ul>
</s:if>
<s:if test="(customer.role.rightCode>>1)%2==1">
<h3>大分类管理</h3>
<ul>
 <li><s:a href="AdminAddCategory.jsp">添加大分类</s:a></li>
 <li><s:a href="AdminDandUCategory.action">更新和删除</s:a></li>
</ul>
</s:if>
<s:if test="(customer.role.rightCode>>2)%2==1">
<h3>小分类管理</h3>
<ul>
 <li><s:a href="AdminAddSecondCategory.action">添加小分类</s:a></li>
 <li><s:a href="AdminDandUSecondCategory.action">更新和删除</s:a></li>
</ul>
</s:if>
<s:if test="(customer.role.rightCode>>3)%2==1">
<h3>订单管理</h3>
<ul>
<li><s:a href="WaitDealOrder.action">待处理订单</s:a></li>
<li><s:a href="SendedOrder.action">已发货订单</s:a></li>
<li><s:a href="Dealed.action">交易完成的订单</s:a></li>
</ul>
</s:if>
<s:if test="(customer.role.rightCode>>4)%2==1">
<h3>购物卡管理</h3>
<ul>
<li><s:a href="AdminProduceMoneyCard.jsp">生产充值卡</s:a></li>
<li><s:a href="AdminFindMoneyCard.jsp">充值卡查询</s:a></li>
</ul>
</s:if>
<s:if test="(customer.role.rightCode>>5)%2==1">
<h3>用户管理</h3>
<ul>
<li><s:a href="AdminFindCustomer.jsp">查找用户</s:a>
</ul>
</s:if>
</body>
</html>
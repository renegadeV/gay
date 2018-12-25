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
<h3>图书管理</h3>
<ul>
 <li><s:a href="AdminWillAddBook.action">添加图书</s:a></li>
 <li><s:a href="AdminDandUBook.action">更新和删除</s:a></li>
</ul>
<h3>大分类管理</h3>
<ul>
 <li><s:a href="AdminAddCategory.jsp">添加大分类</s:a></li>
 <li><s:a href="AdminDandUCategory.action">更新和删除</s:a></li>
</ul>
<h3>小分类管理</h3>
<ul>
 <li><s:a href="AdminAddSecondCategory.action">添加小分类</s:a></li>
 <li><s:a href="AdminDandUSecondCategory.action">更新和删除</s:a></li>
</ul>
<h3>订单管理</h3>
<ul>
<li><s:a href="WaitDealOrder.action">待处理订单</s:a></li>
<li><s:a href="SendedOrder.action">已发货订单</s:a></li>
<li><s:a href="Dealed.action">交易完成的订单</s:a></li>
</ul>
<h3>购物卡管理</h3>
<ul>
<li><s:a href="AdminProduceMoneyCard.jsp">生产充值卡</s:a></li>
<li><s:a href="AdminFindMoneyCard.jsp">充值卡查询</s:a></li>
</ul>
<h3>用户管理</h3>
<ul>
<li><s:a href="AdminFindCustomer.jsp">查找用户</s:a>
</ul>
</body>
</html>

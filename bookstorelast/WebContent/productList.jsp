<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>传智网上商城</title>
</head>
<body>
	
	<s:include value="UserMain.jsp"/>
	<s:include value="main.jsp"/>

<!--  <div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
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
		</div>
	</div>
</div>
-->
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
</s:iterator> -->
</body></html>
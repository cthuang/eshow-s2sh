<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<s:action name="product-category!list" id="productCategorys"
	executeResult="false" />
<div class="side fl">
	<div class="yahei cate">
		<h3>CATEGORIES</h3>
		<ul>
			<s:iterator value="%{#productCategorys.productCategories}">
				<li><a
					href="http://www.promisingpromos.com/product/category/${id}"
					title="${name }">${name }</a></li>
			</s:iterator>
		</ul>
	</div>
	<s:action name="product!search" id="productsByCount">
		<s:param name="query.order">count</s:param>
		<s:param name="query.desc">true</s:param>
		<s:param name="query.pagesize">6</s:param>
	</s:action>
	<div class="hotproduct">
		<h3 class="yahei">HOT PRODUCTS</h3>
		<ul class="clearfix">
			<s:iterator value="%{#productsByCount.products}" status="rowStatus" var="product">
				<li><a href="http://www.promisingpromos.com/product/view/${id}"><img
						src="${product.img}!small.jpg" /> </a></li>
			</s:iterator>
		</ul>
	</div>
</div>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<c:set var="title">产品类型管理</c:set>
<c:set var="title1">产品类型列表</c:set>
<head>
	<title>产品类型</title>
	<link rel="stylesheet"
		href="<c:url value='/admin/styles/productCategory.css'/>" type="text/css" />
</head>
<body>
	<div class="container mt">
		<div class="row-fluid">
			<s:include value="../left.jsp"></s:include>
			<div class="span10">
				<ul class="breadcrumb">
					<li><a href="${ctx}/admin/index">首页</a> <span class="divider">/</span>
					</li>
					<li><a href="${ctx}/admin/productType/">${title}</a> <span
						class="divider">/</span></li>
					<li class="active">${title1}</li>
				</ul>

				<div class="well com">
					<div class="page-header">
						<div class="pull-right">
							<a href="<c:url value='/admin/productCategory/add'/>" class="btn btn-primary">添加</a>
						</div>
						<h3 class="yahei">产品类型列表</h3>
					</div>
					<ul id="myTab" class="nav nav-tabs">
						<li><a data-toggle="tab"
							href="<c:url value='/admin/product'/>"> 产品列表</a></li>
						<li class="active"><a data-toggle="tab"
							href="<c:url value='/admin/productCategory'/>"> 产品分类</a></li>
					</ul>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>#</th>
								<th>分类名称</th>
								<th>备注 </th>
								<th>搜索</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:action name="product-category!list" id="productCategoryList"
								executeResult="false" />
							<s:iterator value="%{#productCategoryList.productCategories}"
								status="rowStatus">
								<tr id="market20">
									<td id="productCategory${id}">${id }</td>
									<td>${name }</td>
									<td>${description }</td>
									<td><a href="<c:url value='/admin/product/c/${id}'/>">进入</a></td>
									<td><a href="<c:url value='/admin/productCategory/edit/${id}'/>">修改</a> <a
										href="${ctx }/product-category!delete.action?id=${id}"
										onclick="deleteData('确定要删除该信息吗？','market',20);">删除</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<%@ include file="/common/page.jsp"%>		
				</div>
			</div>
		</div>
	</div>
</body>


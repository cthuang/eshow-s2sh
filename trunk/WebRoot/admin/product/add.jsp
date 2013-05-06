<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>产品</title>
	<link rel="stylesheet" href="<c:url value='/admin/styles/product.css'/>"
		type="text/css" />
	<link media="screen" type="text/css"
		href="<c:url value='/scripts/validate/theme/grey/formcheck.css'/>"
		rel="stylesheet" />
	<script type="text/javascript"
		src="<c:url value='/scripts/validate/lang/zh-CN.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/scripts/validate/formcheck.js'/>"></script>
	<script type="text/javascript">
	 	window.addEvent('domready', function() {
			new FormCheck('productForm');
		});
    </script>
</head>
<body>
	<div class="container mt">
		<div class="row-fluid">
			<s:include value="../left.jsp"></s:include>
			<div class="span10">
				<ul class="breadcrumb">
					<li><a href="${ctx}/admin/index">首页</a> <span class="divider">/</span>
					</li>
					<li class="active">${title}</li>
				</ul>
				<s:include value="../title.jsp"></s:include>
				<div class="well com">
					<div class="page-header">
						<h3 class="yahei">产品信息添加</h3>
					</div>
					<div id="mainTab">
						<ul id="myTab" class="nav nav-tabs">
						<li><a data-toggle="tab" href="<c:url value='/admin/product'/>"> 产品列表</a></li>
						<li><a data-toggle="tab" href="<c:url value='/admin/productCategory'/>"> 产品分类</a></li>
						<li><a data-toggle="tab" href="<c:url value='/admin/product/view'/>"> 产品详细</a></li>
						<li class="active"><a data-toggle="tab" href="<c:url value='/admin/product/add'/>"> 添加产品</a></li>
					</ul>
					</div>
					<div id="productEdit">
						<s:form id="productForm" action="product!save.html" method="post"
							enctype="multipart/form-data">
							<p>
								<span class="l">产品名称:&nbsp;</span>
								<span class="r">&nbsp; <input name="product.name"
										class="inputtext text-input validate['required']"  style="width: 300px;" maxlength="50"
										type="text" onblur="this.className='inputtext'" /> </span>
							</p>
							<p>
								<span class="l">选择分类:&nbsp;</span>
								<span class="r">&nbsp; <s:action
										name="productCategory!list" id="productCategoryList"
										executeResult="false" /> <select name="productCategoryId">
										<s:iterator value="%{#productCategoryList.productCategories}"
											status="rowStatus">
											<option value="${id}">
												${name}
											</option>
										</s:iterator>
									</select> </span>
							</p>
							<p>
								<span class="l">选择图片:&nbsp;</span>
								<span class="r">&nbsp; <input type="file" name="file"
										size="38" class="inputtext text-input validate['required']" /> </span>
							</p>
							<script language="javascript">
							$(document).addEvent(function() {
							    window.onbeforeunload = function() {
							        if (getContentLength() >0)
							        {
							            return "文章还没发表，离开将丢失当前的内容";
							        }
							    };
							});
							</script>
							<p>
								<span class="l">内&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;容:&nbsp;</span>
								<span class="r"> <script type="text/javascript">
								    KE.show({
								        id : 'ke-text'
								    });
								 </script> <textarea id="ke-text" name="product.content"
										style="width: 600px; height: 300px;"></textarea> </span>
							</p>
							<p style="width: 640px; text-align: center;">
								<input type="submit" class="botton" value="提交"
									onmouseout="this.className='botton';"
									onmouseover="this.className='botton2';" />
								<input type="button" class="botton_close1" value="取消"
									onmouseout="this.className='botton_close1';"
									onmouseover="this.className='botton_close2';"
									onclick="javascript:history.back();"/>
							</p>
							<p>
								<input type="hidden" id="securitiesIds" name="listSecuritiesIds" />
							</p>
							<div class="c h10"></div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

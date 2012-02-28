<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div id="appSide">
	<div id="appSideBg">
		<ul class="appList">
		 	<li>
				<img src="<c:url value='/admin/images/app_list_twitter.gif'/>">
				<a href="<c:url value='/admin/twitter'/>">微博客</a>
				<em><a href="<c:url value='/admin/twitter/add'/>">发表</a> </em>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_blog.gif'/>">
				<a href="<c:url value='/admin/blog'/>">日志</a>
				<em><a href="<c:url value='/admin/blog/add'/>">发表</a> </em>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_album.gif'/>">
				<a href="<c:url value='/admin/album'/>">相册</a>
				<em><a href="<c:url value='/admin/photo/add'/>">上传图片</a> </em>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_topic.gif'/>">
				<a href="<c:url value='/admin/topic'/>">讨论区</a>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_product.gif'/>">
				<a href="<c:url value='/admin/product'/>">产品</a>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_service.gif'/>">
				<a href="<c:url value='/admin/service'/>">服务</a>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_feedback.gif'/>">
				<a href="<c:url value='/admin/feedback'/>">留言板</a>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_info.gif'/>">
				<a href="<c:url value='/admin/info'/>">信息页</a>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_user.gif'/>">
				<a href="<c:url value='/admin/user'/>">用户管理</a>
			</li>
			<li>
				<img src="<c:url value='/admin/images/app_list_system.gif'/>">
				<a href="<c:url value='/admin/system'/>">系统管理</a>
			</li>
		</ul>
		<div class="appPix"></div>
		<div class="appAdd">
			<ul>
				<li class="addapp">
					<a href="<c:url value='/admin/app/add'/>">添加组件</a>
				</li>
				<li class="setapp">
					<a href="<c:url value='/admin/app'/>">管理组件</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="c"></div>
	<div class="boxs2_lt"></div>
	<div class="boxs2_lb"></div>
</div>
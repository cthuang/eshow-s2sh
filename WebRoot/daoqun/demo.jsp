<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>移动互联网</title>
<meta name="keywords" content="移动互联网" />
<meta name="description" content="移动互联网" />
</head>
<script src="./scripts/jquery-1.8.3.min.js"></script>
<script>
	$(function() {
		$("div [id^='tabcc_']").each(function(i, ob) {
			$(ob).find('a').bind('click', function() {
				$(ob).find('a').removeClass('on');
				$(this).addClass('on');
				var cid = $(this).attr('cid');
				$(ob).siblings('div').hide();
				$(ob).siblings("div[id='courseList_" + cid + "']").show();
			});
		});
	});
</script>
<body>
	<c:set var="current">demo</c:set>
	<%@ include file="common/header.jsp"%>
	<div class="wapper clearfix phone">
		<h3 class="yahei text-center">那些曾经开发的网站与APP</h3>
		<div class="core clearfix">
			<h3 class="yahei">APP应用类</h3>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/baobao.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">帮趣宝宝</a>
				</h6>
				<p>
					<span class="color7f">一款通过照片+语音的宝宝学习应用</span>
				</p>
			</div>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/wawa.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">娃娃</a>
				</h6>
				<p>
					<span class="color7f">高端母婴导购APP</span>
				</p>
			</div>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/bukuai.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">捕快</a>
				</h6>
				<p>
					<span class="color7f">基于移动互联网的本地化生活搜索工具</span>
				</p>
			</div>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/jiequtao.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">街区淘</a>
				</h6>
				<p>
					<span class="color7f">小区生活服务平台</span>
				</p>
			</div>
			<p class="clearfix">以做自己产品的心态做好每一个案例。我们将客户需求，技术架构，用户体验融入应用的每一个细节，提高产品价值。</p>
		</div>
		<div class="core clearfix">
			<h3 class="yahei">网站开发类</h3>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/baobao.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">帮趣网</a>
				</h6>
				<p>
					<span class="color7f">一款通过照片+语音的宝宝学习应用</span>
				</p>
			</div>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/wawa.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">街区淘</a>
				</h6>
				<p>
					<span class="color7f">高端母婴导购APP</span>
				</p>
			</div>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/bukuai.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">HiNet旅游网</a>
				</h6>
				<p>
					<span class="color7f">基于移动互联网的本地化生活搜索工具</span>
				</p>
			</div>
			<div class="fl list yahei">
				<a href=""><img src="./images/app/jiequtao.jpg" width="200"
					height="300"> </a>
				<h6>
					<a class="black" href="">微博</a>
				</h6>
				<p>
					<span class="color7f">小区生活服务平台</span>
				</p>
			</div>
			<p class="clearfix">以做自己产品的心态做好每一个案例。我们将客户需求，技术架构，用户体验融入应用的每一个细节，提高产品价值。</p>
		</div>
	</div>
</body>

<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<s:action name="info!view" id="view" executeResult="false" />
<head>
	<title>修改信息${view.info.title}</title>
	<link rel="stylesheet" href="<c:url value='/admin/styles/info.css'/>"
		type="text/css" />
	<script type="text/javascript" charset="utf-8"
		src="<c:url value="/components/kindeditor/kindeditor.js"/>"></script>
	<%@ include file="/common/validate.jsp"%>
	<script type="text/javascript">
		window.addEvent('domready', function() {
			new FormCheck('infoForm');
		});
    </script>
</head>
<body>
	<div id="main">
		<s:include value="../left.jsp"></s:include>
		<div id="mainarea">
			<div id="mainarea_bg">
				<div id="content">
					<div id="mainTop">
						<h2>
							<img src="<c:url value='/admin/images/app_list_info.gif'/>" />
							信息中心
						</h2>
					</div>
					<div id="mainTab">
						<ul>
							<li>
								<span class="txt6"><a href="<c:url value='/admin/info'/>">信息列表</a>
								</span>
							</li>
							<li class="on">
								<span class="txt6"><a>信息修改</a> </span>
							</li>
							<li class="navtxt">
								<a href="<c:url value='/admin/info/add'/>">添加信息</a>
							</li>
						</ul>
					</div>
					<div id="analysisEdit">
						<s:form id="infoForm" action="info!update" method="post">
							<s:hidden name="id" value="%{#view.info.id}"></s:hidden>
							<p>
								<span class="l">信息URL&nbsp;</span>
								<span class="r">&nbsp; <input name="info.url"
										class="inputtext" style="width: 200px;" maxlength="50"
										type="text" onblur="this.className='inputtext'"
										value="${view.info.url}" /> </span>
							</p>
							<p>
								<span class="l">信息标题&nbsp;</span>
								<span class="r">&nbsp; <input name="info.title"
										class="inputtext" style="width: 200px;" maxlength="50"
										type="text" onblur="this.className='inputtext'"
										value="${view.info.title}" /> </span>
							</p>
							<p>
								<span class="l">信息内容&nbsp;</span>
								<span class="1">&nbsp; <script type="text/javascript">
								    KE.show({
								        id : 'ke-text'
								    });
								 </script> <textarea id="ke-text" name="info.content"
										class="textarea text-input validate['required']"
										style="width: 600px; height: 300px;">${view.info.content}</textarea>
								</span>
							</p>
							<div class="c"></div>
							<div class="c h5"></div>
							<span class="l"></span>
							<div class="c h10"></div>
							<p style="width: 640px; text-align: center;">
								<input type="submit" class="botton" value="发表"
									onmouseout="this.className='botton';"
									onmouseover="this.className='botton2';" />
								<input type="button" class="botton_close1" value="取消"
									onmouseout="this.className='botton_close1';"
									onmouseover="this.className='botton_close2';"
									onclick="javascript:history.back();" />
							</p>
						</s:form>
					</div>
				</div>
				<div class="c"></div>
			</div>
			<div class="c"></div>
			<div class="boxs3_rt"></div>
			<div class="boxs3_lb"></div>
			<div class="boxs3_rb"></div>
		</div>
	</div>
</body>


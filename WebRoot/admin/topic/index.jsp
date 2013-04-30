<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<s:action name="user!view" id="view" executeResult="false" />
<c:set var="myid">
	<authz:authentication operation='id' />
</c:set>
<%@ taglib uri="/WEB-INF/stringutil.tld" prefix="util"%>
<head>
	<title>讨论区</title>
	<link rel="stylesheet" href="<c:url value='/admin/styles/topic.css'/>"
		type="text/css" />
</head>
<body>
	<div class="container mt">
		<div class="row-fluid">
			<s:include value="../left.jsp"></s:include>
			<div class="span10">
				<s:include value="../title.jsp"></s:include>

				<div class="well com">
					<div class="page-header">
						<div class="pull-right">
							<a href="<c:url value='/admin/topic/add'/>" class="btn btn-primary">添加</a>
						</div>
						<h3 class="yahei">信息中心</h3>
					</div>
					<div id="analysis">
						<div class="subnav">
							<strong>全部</strong>
							<s:action name="board!list" id="boardList" executeResult="false">
							</s:action>
							<s:iterator value="%{#boardList.boards}" status="rowStatus">
								<a href="<c:url value='/admin/topic/b/${id}?squence=1'/>">${name}</a>
							</s:iterator>
						</div>
						<table class="forum-table">
							<colgroup>
								<col width="17" />
								<col width="85" />
								<col />
								<col width="40" />
								<col width="100" />
								<col width="90" />
								<col width="70" />
								<col width="70" />
								<col width="90" />
							</colgroup>
							<tbody>
								<tr>
									<th></th>
									<th align="left">
										分类
									</th>
									<th align="left">
										标题
									</th>
									<th align="center"></th>
									<th align="center">
										作者
									</th>
									<th align="center">
										更新时间
									</th>
									<th align="center">
										浏览/回复
									</th>
									<th align="center">
										推荐/收藏
									</th>
									<th>
										发表时间
									</th>
								</tr>
								<s:action name="topic!search" id="topicList"
									executeResult="false">
									<s:param name="queryBean.state">1</s:param>
									<s:param name="queryBean.order">addTime</s:param>
									<s:param name="queryBean.desc">true</s:param>
								</s:action>
								<s:iterator value="%{#topicList.topics}" status="rowStatus">
									<tr onmouseover='this.style.backgroundColor ="#f9f9f9"'
										onmouseout='this.style.backgroundColor =""'>
										<td>
											<img src="<c:url value='/admin/images/icon_page.gif'/>" />
										</td>
										<td align="left">
											<em>${board.name}</em>
										</td>
										<td>
											<a href="<c:url value='/admin/topic/view/${id}'/>"
												title="${title}">${util:preview(title,22)}</a>
										</td>
										<td align="right">
											<img src="<c:url value='/admin/images/icon_zjh.gif'/>" />
											&nbsp;
										</td>
										<td align="center">
											<a href="/eshow/admin/topic/workmate/${user.id}">${user.nickname}</a>
										</td>
										<td align="center" style="font-size: 11px;">
											<s:date name='%{updateTime}'
												format='yyyy-MM-dd HH:mm' />
										</td>
										<td align="center">
											${count}/${commentSize}
										</td>
										<td align="center">
											6/0
										</td>
										<td align="center" style="font-size: 11px;">
											<s:date name='%{addTime}'
												format='yyyy-MM-dd' />
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						<div id="articeBottom">
							<%@ include file="/common/page.jsp"%>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="main">
		<s:include value="../left.jsp"></s:include>
		<div id="mainarea">
			<div id="mainarea_bg">
				<div id="content">
					<div id="mainTop">
						<h2>
							<img src="<c:url value='/admin/images/app_list_topic.gif'/>" />
							讨论区
						</h2>
					</div>
					<div id="mainTab">
						<ul>
							<li class="on">
								<span class="txt6"><a
									href="<c:url value='/admin/topic'/>">讨论区</a> </span>
							</li>
							<li>
								<span class="txt6"><a
									href="<c:url value='/admin/topic/audit'/>">未审核</a> </span>
							</li>
							<li>
								<span class="txt6"><a
									href="<c:url value='/admin/topic/mine'/>">我发表的话题</a> </span>
							</li>
							<li>
								<span class="txt6"><a
									href="<c:url value='/admin/topic/replied'/>">我参与的话题</a> </span>
							</li>
							<li>
								<span class="txt6"><a
									href="<c:url value='/admin/board'/>">话题板块</a> </span>
							</li>

							<li class="navtxt">
								<a href="<c:url value='/admin/topic/add'/>">发表话题</a>
							</li>

						</ul>
					</div>
					<div id="analysis">
						<div class="subnav">
							<strong>全部</strong>
							<s:action name="board!list" id="boardList" executeResult="false">
							</s:action>
							<s:iterator value="%{#boardList.boards}" status="rowStatus">
								<a href="<c:url value='/admin/topic/b/${id}?squence=1'/>">${name}</a>
							</s:iterator>
						</div>
						<table class="forum-table">
							<colgroup>
								<col width="17" />
								<col width="85" />
								<col />
								<col width="40" />
								<col width="100" />
								<col width="90" />
								<col width="70" />
								<col width="70" />
								<col width="90" />
							</colgroup>
							<tbody>
								<tr>
									<th></th>
									<th align="left">
										分类
									</th>
									<th align="left">
										标题
									</th>
									<th align="center"></th>
									<th align="center">
										作者
									</th>
									<th align="center">
										更新时间
									</th>
									<th align="center">
										浏览/回复
									</th>
									<th align="center">
										推荐/收藏
									</th>
									<th>
										发表时间
									</th>
								</tr>
								<s:action name="topic!search" id="topicList"
									executeResult="false">
									<s:param name="queryBean.state">1</s:param>
									<s:param name="queryBean.order">addTime</s:param>
									<s:param name="queryBean.desc">true</s:param>
								</s:action>
								<s:iterator value="%{#topicList.topics}" status="rowStatus">
									<tr onmouseover='this.style.backgroundColor ="#f9f9f9"'
										onmouseout='this.style.backgroundColor =""'>
										<td>
											<img src="<c:url value='/admin/images/icon_page.gif'/>" />
										</td>
										<td align="left">
											<em>${board.name}</em>
										</td>
										<td>
											<a href="<c:url value='/admin/topic/view/${id}'/>"
												title="${title}">${util:preview(title,22)}</a>
										</td>
										<td align="right">
											<img src="<c:url value='/admin/images/icon_zjh.gif'/>" />
											&nbsp;
										</td>
										<td align="center">
											<a href="/eshow/admin/topic/workmate/${user.id}">${user.nickname}</a>
										</td>
										<td align="center" style="font-size: 11px;">
											<s:date name='%{updateTime}'
												format='yyyy-MM-dd HH:mm' />
										</td>
										<td align="center">
											${count}/${commentSize}
										</td>
										<td align="center">
											6/0
										</td>
										<td align="center" style="font-size: 11px;">
											<s:date name='%{addTime}'
												format='yyyy-MM-dd' />
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						<div id="articeBottom">
							<%@ include file="/common/page.jsp"%>
						</div>
					</div>
				</div>
				<input type="hidden" id="stype" value="" />
				<div class="c"></div>
			</div>
			<div class="c"></div>
			<div class="boxs3_rt"></div>
			<div class="boxs3_lb"></div>
			<div class="boxs3_rb"></div>
		</div>
	</div>
</body>


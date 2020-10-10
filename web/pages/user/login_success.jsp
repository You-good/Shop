<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp"%>
		<title>网上商城会员注册页面</title>
		<style type="text/css">
			h1 {
				text-align: center;
				margin-top: 200px;
			}

			h1 a {
				color: red;
			}
		</style>

	</head>
	<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<div>
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临网上商城</span>
				<a href="OrderServlet?action=show">我的订单</a>
				<a href="LogoutServlet">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
		</div>

		<div id="main">
			<h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>
		</div>

		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>

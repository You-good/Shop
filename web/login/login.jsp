<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp"%>

		<title>网上商城会员登录页面</title>
<!--		<base href="http://localhost:8080/shop_war_exploded/">-->

	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
		</div>

		<div class="login_banner">

			<div id="l_content">
				<span class="login_word">欢迎登录</span>
			</div>

			<div id="content">
				<div class="login_form">
					<div class="login_box">
						<div class="tit">
							<h1>网上商城会员</h1>
							<a href="regist.jsp">立即注册</a>
						</div>
						<div class="msg_cont">
							<b></b>
							<span class="errorMsg">${requestScope.errorMsg}</span>
						</div>
						<div class="form">
							<form action="UserServlet" method="POST">
								<input hidden="hidden" name="action" value="login">
								<label>用户名称：</label>
								<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
								<br />
								<br />
								<label>用户密码：</label>
								<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
								<br />
								<br />
								<input type="submit" value="登录" id="sub_btn" />
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>

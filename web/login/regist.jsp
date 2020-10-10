<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp"%>
		<title>网上商城会员注册页面</title>
		<style type="text/css">
			.login_form {
				height: 420px;
				margin-top: 25px;
			}
		</style>

		<script>
			$(function(){
				//用户名验证
				$("#username").blur(function(){
					const username = this.value;
					const regexName = /^\w{5,12}$/;
					if (regexName.test(username)!=true){
						// alert("用户名不合法");
						$(".errorMsg").text("用户名不合法");
						$("#username").focus();
					}else{
						$.getJSON("http://localhost:8080/shop_war_exploded/UsernameServlet",
								"username="+username,function (data) {

									if (data.username){
										console.log(data.username);
										$(".errorMsg").text("用户名已存在");
										$("#username").focus();

									}else{
										$(".errorMsg").text("");
									}
						});
					}
				});
				//密码验证
				$("#password").blur(function(){
					const password = $("#password").val();
					const regexpwd = /^\w{5,12}$/
					if(!regexpwd.test(password)){
						$(".errorMsg").text("密码不合法");
						$("#password").focus();
					}else{
						$(".errorMsg").text("");
					}
				});
				//确认密码验证
				$("#repwd").blur(function () {
					const repwd = $("#repwd").val();
					const password = $("#password").val();
					if (password=="" || password==null){
						$(".errorMsg").text("密码不能为空");
						$("#password").focus();
					}else{
						if(repwd!=password){
							$(".errorMsg").text("密码与确认密码不一致");
							$("#repwd").focus();
						}else{
							$(".errorMsg").text("");
						}
					}
				});
				//邮箱验证
				$("#email").blur(function(){
					const email = $("#email").val();
					const regexEamil=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					if(!regexEamil.test(email)){
						$(".errorMsg").text("邮箱不合法");
						$("#email").focus();
					}else{
						$(".errorMsg").text("");
					}
				});
				//验证码验证
				$("#code").blur(function(){
					const code=$.trim($("#code").val());
					if(code=="" || code == null){
						$(".errorMsg").text("验证码不能为空");
						$("#code").focus();
					}else{
						$(".errorMsg").text("");
					}
				});
			});
		</script>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
		</div>

		<div class="login_banner">

			<div id="l_content">
				<span class="login_word">欢迎注册</span>
			</div>

			<div id="content">
				<div class="login_form">
					<div class="login_box">
						<div class="tit">
							<h1>注册网上商城会员</h1>
						</div>
						<br/>
						<span class="errorMsg" style="color: red">${requestScope.errorMsg}</span>
						<div class="form">
							<form action="UserServlet" method="post">
								<input hidden="hidden" name="action" value="regist">
								<label>用户名称：</label>
								<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
								<br />
								<br />
								<label>用户密码：</label>
								<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
								<br />
								<br />
								<label>确认密码：</label>
								<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
								<br />
								<br />
								<label>电子邮件：</label>
								<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
								<br />
								<br />
								<label>验证码：</label>
								<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
								<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
								<br />
								<br />
								<input type="submit" value="注册" id="sub_btn" />
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>

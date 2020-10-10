<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp"%>
		<title>我的订单</title>
		<style type="text/css">
			h1 {
				text-align: center;
				margin-top: 200px;
			}
		</style>
		<script>
			$(function(){
				$(".detailBtn").click(function(){
					var orderNum = $($(this).parents("tr").children("td")[0]).html();
					alert("orderNum="+orderNum);
					window.location.href = "OrderItemServlet?orderNum="+orderNum;
				});
			});
		</script>
	</head>
	<body>

		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">我的订单</span>
			<div>
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临网上商城</span>
				<a href="OrderServlet?action=show">我的订单</a>
				<a href="http://localhost:8080/shop/LogoutServlet">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
		</div>

		<div id="main">

			<table>
				<tr>
					<td hidden="hidden">订单号</td>
					<td>日期</td>
					<td>金额</td>
					<td>状态</td>
					<td>详情</td>
				</tr>
				<c:forEach items="${requestScope.orders}" var="order">
					<tr>
						<td hidden="hidden">${order.orderNum}</td>
						<td>${order.date}</td>
						<td>${order.total}</td>
						<td>
							<c:if test="${order.state==0}">未发货</c:if>
							<c:if test="${order.state==1}">已发货</c:if>
							<c:if test="${order.state==2}">已签收</c:if>
						</td>
						<td><input type="button" class="detailBtn" value="查看详情"/></td>
					</tr>
				</c:forEach>

			</table>


		</div>

		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>

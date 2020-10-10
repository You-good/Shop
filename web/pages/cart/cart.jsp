<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp"%>
		<title>购物车</title>
		<script>
			$(function(){
				$(".delBtn").click(function(){
					var cartItemId = $($(this).parents("tr").children("td")[0]).html();
					// alert("想要删除的？"+cartItemId);
					if (confirm("想要删除【"+$($(this).parents("tr").children("td")[1]).html()+"】?")){
						window.location.href = "CartServlet?action=delItem&cartItemId="+cartItemId;
					}else{
						return false;
					}

				});
			});
		</script>
	</head>
	<body>

		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">购物车</span>
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
					<td hidden="hidden">id</td>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<c:if test="${requestScope.items.size()>0}">
					<c:forEach begin="0" end="${requestScope.items.size()-1}" var="i">
						<tr>
							<td hidden="hidden">${requestScope.items.get(i).cartItemId}</td>
							<td>${requestScope.items.get(i).goodsName}</td>
							<td>${requestScope.items.get(i).number}</td>
							<td>${requestScope.items.get(i).price}</td>
							<td>${requestScope.items.get(i).money}</td>
							<td><input class="delBtn" type="button" value="删除"></td>
						</tr>
					</c:forEach>
				</c:if>


			</table>

			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${requestScope.items.size()}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${requestScope.totalMoney}</span>元</span>
				<span class="cart_span">

					<c:if test="${requestScope.totalMoney==0}">
						<a href="">清空购物车</a>
					</c:if>
					<c:if test="${requestScope.totalMoney>0}">
						<a href="OrderServlet?action=delItems">清空购物车</a>
					</c:if>
				</span>
				<span class="cart_span">

					<c:if test="${requestScope.totalMoney==0}">
						<a href="">去结账</a>
					</c:if>
					<c:if test="${requestScope.totalMoney>0}">
						<a href="OrderServlet?action=add&total=${requestScope.totalMoney}">去结账</a>
					</c:if>
				</span>
			</div>

		</div>
		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>

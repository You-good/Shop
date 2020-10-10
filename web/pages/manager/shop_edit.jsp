<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp"%>
		<title>编辑商品</title>
		<style type="text/css">
			h1 {
				text-align: center;
				margin-top: 200px;
			}

			h1 a {
				color: red;
			}
		</style>
<%--		<script>--%>
<%--			$(function () {--%>
<%--			});--%>
<%--		</script>--%>
	</head>
	<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">编辑商品</span>
			<div>
				<a href="GoodsListServlet?action=behind&pageNum=1">商品管理</a>
				<a href="pages/manager/order_manager.jsp">订单管理</a>
				<a href="index.jsp">返回商城</a>
			</div>
		</div>

		<div id="main">
			<c:if test="${param.operate=='add'}">
				<form action="GoodsAddServlet" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>名称</td>
							<td style="text-align: left"><input name="goodsName" type="text"/></td>
						</tr>
						<tr>
							<td>价格</td>
							<td style="text-align: left"><input name="goodsPrice" type="text"/></td>
						</tr>
						<tr>
							<td>品牌</td>
							<td style="text-align: left"><input name="goodsBrand" type="text"/></td>
						</tr>
						<tr>
							<td>销量</td>
							<td style="text-align: left"><input name="goodsSales" type="text"/></td>
						</tr>
						<tr>
							<td>库存</td>
							<td style="text-align: left"><input name="goodsRepertory" type="text"/></td>
						</tr>
						<tr>
							<td>图片</td>
							<td><input name="picture" type="file"/></td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align: left"><input type="submit" value="提交" /></td>
						</tr>
					</table>

				</form>
			</c:if>
			<c:if test = "${param.operate=='modify'}">
				<form action="GoodsModifyServlet?action=two" method="post" enctype="multipart/form-data">
					<input hidden="hidden" name="pageNum" type="text" value="${requestScope.pageNum}" />
					<input hidden="hidden" name="goodsId" type="text" value="${requestScope.goodsId}"/>
					<table>
						<tr>
							<td>名称</td>
							<td style="text-align: left"><input name="goodsName" type="text" value="${requestScope.goods.goodsName}"/></td>
						</tr>
						<tr>
							<td>价格</td>
							<td style="text-align: left"><input name="goodsPrice" type="text" value="${requestScope.goods.price}"/></td>
						</tr>
						<tr>
							<td>品牌</td>
							<td style="text-align: left"><input name="goodsBrand" type="text" value="${requestScope.goods.brand}"/></td>
						</tr>
						<tr>
							<td>销量</td>
							<td style="text-align: left"><input name="goodsSales" type="text" value="${requestScope.goods.sales}"/></td>
						</tr>
						<tr>
							<td>库存</td>
							<td style="text-align: left"><input name="goodsRepertory" type="text" value="${requestScope.goods.repertory}"/></td>
						</tr>
						<tr>
							<td>图片</td>
							<td><input name="picture" type="file" value="${requestScope.goods.picture}"/></td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align: left"><input type="submit" value="提交" /></td>
						</tr>
					</table>
				</form>
			</c:if>



		</div>

		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>

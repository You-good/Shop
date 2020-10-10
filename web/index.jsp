<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<%@ include file="/pages/common/header.jsp" %>
		<title>商城首页</title>
		<script>
			$(function () {
				$.ajax({
					url: "http://localhost:8080/shop/GoodsListServlet?action=index&pageNum="+$("#pageNum").html(),
					type: "GET",
					success: function (data) {
						var jsonObj = JSON.parse(data);
						//当前页面的商品
						var goodsList = jsonObj[0];
						for (var i = 0; i < jsonObj[0].length; i++){
							var b_listTag = $("<div class='b_list'></div>");
							var img_divTag = $("<div class='img_div'></div>");
							var imgTag = $("<img class='shop_img' alt='' src='static/images/' />");
							var shop_infoTag = $("<div class='shop_info'></div>");
							var shop_nameTag = $("<div class='shop_name'></div>");
							var shop_authorTag = $("<div class='shop_author'></div>");
							var shop_priceTag = $("<div class='shop_price'></div>");
							var shop_salesTag = $("<div class='shop_sales'></div>");
							var shop_amountTag = $("<div class='shop_amount'></div>");
							var shop_addTag = $("<div class='shop_add'></div>");
							$(".list").append(b_listTag);
							b_listTag.append(img_divTag);
							b_listTag.append(shop_infoTag);
							img_divTag.append(imgTag);
							imgTag.attr("src","images/"+jsonObj[0][i].picture);
							shop_infoTag.append(shop_nameTag);
                            shop_nameTag.append("<span hidden='hidden' class='goodsId'>"+jsonObj[0][i].goodsId+"</span>");
							shop_nameTag.append("<span class='sp1'>商品名称：</span>");
							shop_nameTag.append("<span class='sp2'>"+jsonObj[0][i].goodsName+"</span>");
							shop_infoTag.append(shop_authorTag);
							shop_authorTag.append("<span class='sp1'>品牌：</span>");
							shop_authorTag.append("<span class='sp2'>"+jsonObj[0][i].brand+"</span>");
							shop_infoTag.append(shop_priceTag);
							shop_priceTag.append("<span class='sp1'>价格：</span>");
							shop_priceTag.append("<span class='sp2'>"+jsonObj[0][i].price+"</span>");
							shop_infoTag.append(shop_salesTag);
							shop_salesTag.append("<span class='sp1'>销售：</span>");
							shop_salesTag.append("<span class='sp2'>"+jsonObj[0][i].sales+"</span><br />");
							shop_infoTag.append(shop_amountTag);
							shop_salesTag.append("<span class='sp1'>库存：</span>");
							shop_salesTag.append("<span class='sp2'>"+jsonObj[0][i].repertory+"</span>");
							shop_infoTag.append(shop_addTag);
							shop_addTag.append("<button class='addCart btn btn-sm btn-info'>加入购物车</button>");
						}
						//所有商品的数量
						var total = jsonObj[1];
						$("#total").html(total);
						$("#totalRecord").html(total);
						//商品的总页数
						var endPage = jsonObj[2];
						$("#endPageNum").html(endPage);
						$("#endPage").html(endPage);
						for (var j=1;j<endPage+1;++j){
							var pageBtn = null;
							if (j==Number($("#pageNum").html())){
								pageBtn = $("<input type='button' style='background-color:darkgrey' class='pageBtn'/>");
							}else{
								pageBtn = $("<input type='button' class='pageBtn'/>");
							}

							pageBtn.attr("value",j);
							$("#next").before(pageBtn);
						}
						pageBtnClick();
                        addCart();
					},
					dataType: "text"
				});
				//分页跳转按钮
				function pageBtnClick() {
					$(".pageBtn").on('click',function(){
						if ($(this).val()==$("#pageNum").html()){
							return false;
						}else{
							window.location.href = "index.jsp?pageNum="+$(this).val();
						}
					});
				}
				//加入购物车按钮
				function addCart(){
					$(".addCart").on('click',function () {
					    var goodsId = $($($(this).parents(".shop_info").children("div")[0]).children("span")[0]).html();
					    // alert("加入购物车商品的id？"+goodsId);
						window.location.href = "CartServlet?action=add&userId="+$("#userId").html()+"&goodsId="+goodsId+"&pageNum="+$("#pageNum").html();
					});
				}
				//首页
				$("#start").click(function () {
					window.location.href = "index.jsp";
				});
				//末页
				$("#end").click(function () {
					window.location.href = "index.jsp?pageNum="+$("#endPage").html();
				});
				//上一页
				$("#previous").click(function(){
					if ($("#pageNum").html()=="1"){
						return false;
					}else{
						window.location.href = "index.jsp?pageNum="+(Number($("#pageNum").html())-1);
					}
				});
				//下一页
				$("#next").click(function () {
					if ($("#pageNum").html()==$("#endPage").html()){
						return false;
					}else{
						window.location.href = "index.jsp?pageNum="+(Number($("#pageNum").html())+1);
					}
				});
				$("#searchPage").click(function(){
					var pageIndex = Number($("#pn_input").val());
					if (pageIndex<1 || pageIndex>Number($("#endPage").html())){
						alert("无效的页码");
						return false;
					}else{
						window.location.href = "index.jsp?pageNum="+pageIndex;
					}
				});
			});
		</script>
	</head>
	<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif">
			<span class="wel_word">网上商城</span>
			<div>
				<a href="login/login.jsp" class="btn btn-lg btn-info">登录</a> |
				<a href="login/regist.jsp" class="btn btn-lg btn-info">注册</a> &nbsp;&nbsp;
				<a href="CartServlet?action=show" class="btn btn-lg btn-info">购物车</a>
				<a href="pages/manager/manager.jsp" class="btn btn-lg btn-info">后台<c:if test="${param.pageNum==null}">
					<span hidden="hidden" id="pageNum">1</span>
				</c:if><c:if test="${param.pageNum==null}">
					<span hidden="hidden" id="pageNum">1</span>
				</c:if>管理</a>
			</div>
		</div>
		<div id="main">
			<span hidden="hidden" id="userId">${sessionScope.user.userId}</span>
			<c:if test="${param.pageNum==null}">
				<span hidden="hidden" id="pageNum">1</span>
			</c:if>
			<c:if test="${param.pageNum!=null}">
				<span hidden="hidden" id="pageNum">${param.pageNum}</span>
			</c:if>
			<div id="shop">
				<div class="shop_cond">
					<form action="" method="get">
						价格：<input id="min" type="text" name="min" value=""> 元 -
						<input id="max" type="text" name="max" value=""> 元
						<button type="submit" class="btn btn-group-lg btn-primary">查询</button>
					</form>
				</div>
				<div style="text-align: center">
					<span>您的购物车中有3件商品</span>
					<div>
						您刚刚将<span style="color: red">滚筒洗衣机</span>加入到了购物车中
					</div>
				</div>
				<div class="list" style="text-align: center;">
<%--					放商品--%>
				</div>
			</div>

			<div id="page_nav">

				<input type="button" id="start" value="首页">
				<input type="button" id="previous" value="上一页"/>
<%--				分页--%>

				<input type="button" id="next" value="下一页">
				<input type="button" id="end" value="末页">
				共<span id="endPage"></span>页，<span id="total"></span>条记录 到第<input name="pn" id="pn_input" />页
				<button id="searchPage" class="btn btn-sm btn-default">确定</button>
			</div>

		</div>

		<%@ include file="/pages/common/footer.jsp" %>
	</body>
</html>

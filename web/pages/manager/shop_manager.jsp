<%@ page import="com.shop.bean.Goods" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Win
  Date: 2020/10/6
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/pages/common/header.jsp" %>
    <%
        List<Goods> goodsList = (List<Goods>)request.getAttribute("goodsList");//当前页面的商品
        Integer allNumber = (Integer)request.getAttribute("allNumber");//所有商品的数量
        Integer pageNum = (Integer)request.getAttribute("pageNum");//当前页面数
        Integer endPage = (Integer)request.getAttribute("endPage");//总有多少页
    %>
    <title>商品管理</title>
    <script type="text/javascript">
        $(function () {
            $("#add").click(function(){
                window.location.href="pages/manager/shop_edit.jsp?operate=add";
            });
            $(".modify").click(function(){
                var goodsId = Number($($(this).parents("tr").children("td")[0]).html());
                var pageNum = Number($("#pageNow").html());
                window.location.href="GoodsModifyServlet?action=one&goodsId="+goodsId+"&pageNum="+pageNum;

            });
            $(".delete").click(function(){
                if (confirm("你确定要删除 【" + $($(this).parents("tr").children("td")[1]).html() + "】?")){
                    var goodsId = $($(this).parents("tr").children("td")[0]).html();
                    window.location.href="GoodsDeleteServlet?goodsId="+goodsId;
                }else{
                    return false;
                }
            });
            $("#searchBtn").click(function(){
                var pageIndex = $("#pn_input").val();
                if (pageIndex==""){
                    return false;
                }else{
                    var pageIndex = Number(pageIndex);
                    if (pageIndex<1 || pageIndex>Number($("#endPage").html())){
                        alert("无效的页码！");
                        return false;
                    }else{
                        window.location.href="GoodsListServlet?pageNum="+pageIndex;
                    }
                }
            });
        });
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="东方锐智" src="static/img/logo.gif">
    <span class="wel_word">商品管理系统</span>
    <div>
        <a href="GoodsListServlet?pageNum=1">商品管理</a>
        <a href="pages/manager/order_manager.jsp">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <table style="margin-top: 30px">
        <thead>
        <tr>
            <%--            存放当前页数--%>
            <td id="pageNow" hidden="hidden">${requestScope.pageNum}</td>
            <td id="endPage" hidden="hidden">${requestScope.endPage}</td>
            <td colspan="6">
                <button id="add" type="button" class="btn btn-default btn-block btn-info" >添加商品</button>
            </td>
        </tr>
        <tr>
            <td hidden="hidden">ID</td>
            <td>名称</td>
            <td>价格</td>
            <td>品牌</td>
            <td>销量</td>
            <td>库存</td>
            <td>操作</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach begin="0" end="${requestScope.goodsList.size()-1}" var="i">
            <tr>
                <td hidden="hidden">${requestScope.goodsList.get(i).goodsId}</td>
                <td>${requestScope.goodsList.get(i).goodsName}</td>
                <td>${requestScope.goodsList.get(i).price}</td>
                <td>${requestScope.goodsList.get(i).brand}</td>
                <td>${requestScope.goodsList.get(i).sales}</td>
                <td>${requestScope.goodsList.get(i).repertory}</td>
                <td>
                    <button type="button" class="modify btn btn-info btn-sm">修改</button>
                    <button type="button" class="delete btn btn-danger btn-sm">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <div style="text-align: center;margin-top: 25px">
        <div id="page_nav">
            <%--                首页的展示--%>
            <a href="GoodsListServlet?action=behind&pageNum=1" id="start">首页</a>
            <%--                上一页的展示--%>
            <c:if test="${requestScope.pageNum!=1}">
                <a href="GoodsListServlet?action=behind&pageNum=${requestScope.pageNum-1}" id="previous">上一页</a>
            </c:if>
            <c:if test="${requestScope.pageNum==1}">
                <a href="GoodsListServlet?action=behind&pageNum=1" id="previous">上一页</a>
            </c:if>
            <c:forEach begin="1" end="${requestScope.endPage}" var="i">
                <c:if test="${i==requestScope.pageNum}">
                    【${i}】
                </c:if>
                <c:if test="${i!=requestScope.pageNum}">
                    <a href="GoodsListServlet?action=behind&pageNum=${i}">${i}</a>
                </c:if>
            </c:forEach>

            <%--                下一页的展示--%>
            <c:if test="${requestScope.pageNum!=requestScope.endPage}">
                <a href="GoodsListServlet?action=behind&pageNum=${requestScope.pageNum+1}" id="next">下一页</a>
            </c:if>
            <c:if test="${requestScope.pageNum==requestScope.endPage}">
                <a href="GoodsListServlet?action=behind&pageNum=${requestScope.endPage}" id="next">下一页</a>
            </c:if>

            <%--                末页的展示--%>
            <a href="GoodsListServlet?action=behind&pageNum=${requestScope.endPage}" id="end">末页</a>

            <%--                共多少页--%>
            共<span id="totalPageNum">${requestScope.endPage}</span>页，
            <%--                共多少条记录--%>
            <span id="totalRecord">${requestScope.allNumber}</span>条记录
            到第<input name="pn" id="pn_input" />页
            <button id="searchBtn" class="btn btn-sm btn-default">确定</button>
        </div>
    </div>
</div>

<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>
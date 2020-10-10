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
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临网上商城</span>
        <a href="OrderServlet?action=show">我的订单</a>
        <a href="http://localhost:8080/shop_war_exploded/LogoutServlet">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>名称</td>
            <td>品牌</td>
            <td>价格</td>
            <td>数量</td>
            <td>金额</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.date}</td>
                <td>${orderItem.goodsName}</td>
                <td>${orderItem.brand}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.number}</td>
                <td>${orderItem.money}</td>
            </tr>
        </c:forEach>

    </table>


</div>

<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>

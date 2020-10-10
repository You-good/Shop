<%--
  Created by IntelliJ IDEA.
  User: Win
  Date: 2020/9/23
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //    http://localhost:8083/memberdb/
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<link href="static/css/bootstrap.min.css" rel="stylesheet"/>
<script src="static/js/jquery-1.11.3.min.js"></script>
<script src="static/js/bootstrap.js"></script>
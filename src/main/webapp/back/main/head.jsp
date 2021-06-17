<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>标题</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/back/index.jsp" target="main">百知教务系统</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user.username!=null}">
                    <li><a href="javascript:;">欢迎: ${sessionScope.user.username}-----${sessionScope.user.role}</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/logout" target="_parent">退出系统</a></li>
                </c:if>
                <c:if test="${sessionScope.user.username==null}">
                    <li><a href="${pageContext.request.contextPath}/back/login.jsp" target="_parent">点我登录</a></li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>
</body>
</html>
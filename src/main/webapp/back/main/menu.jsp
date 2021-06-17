<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row" style="margin-top: 10%;">
        <div class="col-sm-12">
            <ul class="list-group">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/student/findAll" target="main">学生管理</a></li>
                <c:if test="${sessionScope.user.role=='admin'}">
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/group/findAll" target="main">小组管理</a></li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/clazz/findAll" target="main">班级管理</a></li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/tag/findAll" target="main">标签管理</a></li>
                    <li class="list-group-item"><a href="${pageContext.request.contextPath}/city/findAll" target="main">城市管理</a></li>
                </c:if>
                <!--<li class="list-group-item"><a href="" target="main">用户中心</a></li>-->
            </ul>
        </div>
    </div>
</div>
</body>
</html>
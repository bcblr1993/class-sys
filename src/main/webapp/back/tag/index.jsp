<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
    <title>标签列表</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <input type="button" value="添加标签" class="btn btn-sm btn-info" onclick="location.href='${pageContext.request.contextPath}/back/tag/add.jsp'"/>
        </div>
    </div>
    <div class="row" style="margin-top: 10px; ">
        <div class="col-sm-12">
            <table class="table table-hover table-bordered table-striped">
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>创建时间</th>
                    <th>标签类型</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.tags}" var="tag">
                    <tr>
                        <td>${tag.id}</td>
                        <td>${tag.name}</td>
                        <td><fmt:formatDate value="${tag.createDate}" pattern="yyyy-MM-dd"/></td>
                        <td>
                            <c:if test="${tag.type=='学生'}">
                                <span class="label label-warning">${tag.type}</span>
                            </c:if>
                            <c:if test="${tag.type=='班级'}">
                                <span class="label label-info">${tag.type}</span>
                            </c:if>
                        </td>
                        <td><a href="javascript:;" onclick="delRow(${tag.id})" class="btn btn-danger btn-sm">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>


</body>
</html>
<script>
    function delRow(id){
        if(window.confirm('确定要删除这条记录吗?')) location.href='${pageContext.request.contextPath}/tag/delete?id='+id;
    }
</script>
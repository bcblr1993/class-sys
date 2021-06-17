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
    <title>学生列表</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
    <style>
        .form-control {
            height: 30px;
        }

        .pagination {
            margin-top: 0px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12" style="text-align: center">
            <form class="form-inline" action="${pageContext.request.contextPath}/student/findAll" method="post">
                <div class="form-group">
                    <label>请选择:</label>
                    <select class="form-control" style="height: 30px; width: 100px;" name="colName">
                        <option value="name">姓名</option>
                        <option value="phone">手机</option>
                        <option value="qq">QQ</option>
                    </select>
                    <input type="text" class="form-control" name="colValue" style="height: 30px; width: 300px;">
                </div>

                <button type="submit" class="btn btn-primary btn-sm">搜索</button>
            </form>
        </div>
    </div>
    <div class="row" style="margin-top: 15px;height: 300px">
        <c:if test="${sessionScope.user.role=='admin'}">
            <div class="col-sm-12" style="margin-bottom: 10px;">
                <a href="${pageContext.request.contextPath}/student/toAddPage" class="btn btn-sm btn-success">添加学生信息</a>
            </div>
        </c:if>
        <div class="col-sm-12">
            <c:if test="${requestScope.total!=0}">
                <table class="table table-hover table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>年龄</th>
                        <th>生日</th>
                        <th>星座</th>
                        <th>生肖</th>
                        <th>班级</th>
                        <th>小组</th>
                        <th>就业城市</th>
                        <th>标签</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <c:forEach items="${requestScope.students}" var="student">
                        <tr>
                            <td>${student.name}</td>
                            <td>${student.phone}</td>
                            <td>${student.age}</td>
                            <td><fmt:formatDate value="${student.bir}" pattern="yyyy/MM/dd"/></td>
                            <td>${student.starts}</td>
                            <td>${student.attr}</td>
                            <td>${student.clazz.name}</td>
                            <td>${student.group.name}</td>
                            <td>${student.city.name}</td>
                            <td>
                                <c:forEach items="${student.tags}" var="tag">
                                    ${tag.name}、
                                </c:forEach>
                            </td>
                            <td>
                                <c:if test="${sessionScope.user.role=='admin'}">
                                    <a href="${pageContext.request.contextPath}/student/findOne?studentId=${student.id}"
                                       class="btn btn-warning btn-sm">修改</a>
                                    <a href="" class="btn btn-danger btn-sm">删除</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${requestScope.total==0}">
                <h2 class="text-danger text-center">暂时还没有数据哦~~</h2>
            </c:if>
        </div>
    </div>

    <c:if test="${requestScope.total!=0}">
        <%--分页&下载--%>
        <div class="row">
            <div class="col-sm-8">
                <c:if test="${sessionScope.user.role=='admin'}">
                    <a href="${pageContext.request.contextPath}/student/download?page=${requestScope.page}&colName=${requestScope.colName}&colValue=${requestScope.colValue}"
                       class="btn btn-sm btn-info">下载学生信息到文件中</a>
                </c:if>
            </div>
            <div class="col-sm-4">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${requestScope.page==1}">
                            <li class="disabled">
                                <a href="javascript:;" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${requestScope.page!=1}">
                            <li>
                                <a href="${pageContext.request.contextPath}/student/findAll?page=${requestScope.page-1}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach begin="1" end="${requestScope.totalPage}" varStatus="sta">
                            <li
                                    <c:if test="${requestScope.page==sta.count}">
                                        class="active"
                                    </c:if>
                            >
                                <a href="${pageContext.request.contextPath}/student/findAll?page=${sta.count}">${sta.count}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${requestScope.page==requestScope.totalPage}">
                            <li class="disabled">
                                <a href="javascript:;" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${requestScope.page!=requestScope.totalPage}">
                            <li>
                                <a href="${pageContext.request.contextPath}/student/findAll?page=${requestScope.page+1}"
                                   aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>

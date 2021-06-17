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
	<title>小组列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12" style="margin-bottom: 10px; ">
			<input type="button" value="添加小组" class="btn btn-sm btn-info" onclick="location.href='${pageContext.request.contextPath}/clazz/findAllClazzsForGroups'"/>
		</div>
		<div class="col-sm-12">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th>编号</th>
					<th>组名称</th>
					<th>班级名称</th>
					<th>创建时间</th>
					<th>小组标签</th>
					<th>人数</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.groups}" var="group">
					<tr>
						<td>${group.id}</td>
						<td>${group.name}</td>
						<td>${group.clazz.name}</td>
						<td><fmt:formatDate value="${group.createDate}" pattern="yyyy-MM-dd"/></td>
						<td>
							<c:forEach items="${group.tagNames}" var="tagName">
								<span class="label label-success">${tagName}</span>、
							</c:forEach>
						</td>
						<td><span class="label label-primary">${group.stuCounts}</span></td>
						<td><a href="" class="btn btn-danger btn-sm">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

</body>
</html>
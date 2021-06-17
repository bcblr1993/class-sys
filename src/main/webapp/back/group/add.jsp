<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>添加班级</title>

	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="this is my page">
	<meta name="content-type" content="text/html; charset=utf-8">
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
</head>

<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<form action="${pageContext.request.contextPath}/group/save" method="post">
				<div class="form-group">
					<label>组名称</label>
					<input type="text" class="form-control" name="name"/>
				</div>
				<div class="form-group">
					<label>选择班级</label>
					<select class="form-control" name="clazz.id">
						<c:forEach items="${requestScope.clazzs}" var="clazz">
							<option value="${clazz.id}">${clazz.name}</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" class="btn btn-danger btn-block btn-sm" value="提交"/>
				<input type="button" class="btn btn-info btn-block btn-sm" value="返回上级" onclick="history.go(-1);"/>
			</form>
		</div>
	</div>
</div>



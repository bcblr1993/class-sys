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
			<form action="${pageContext.request.contextPath}/clazz/save" enctype="multipart/form-data" method="post">
				<div class="form-group">
					<label>班级头像:</label>
					<input type="file" class="form-control" name="photo"/>
				</div>
				<div class="form-group">
					<label>班级名称:</label>
					<input type="text" class="form-control" name="name"/>
				</div>
				<div class="form-group">
					<label>选择标签:</label>
					<select name="tag.id" class="form-control">
						<c:forEach items="${requestScope.tags}" var="tag">
							<option value="${tag.id}">${tag.name}</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" class="btn btn-danger btn-block" value="提交"/>
				<input type="button" class="btn btn-info btn-block" value="返回上级" onclick="history.go(-1);"/>
			</form>
		</div>
	</div>
</div>


</body>
</html>

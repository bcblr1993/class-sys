<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
	<title>城市列表</title>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<input type="button" class="btn btn-success btn-sm" value="添加城市" onclick="location.href='${pageContext.request.contextPath}/back/city/add.jsp'"/>
		</div>
	</div>
	<div class="row" style="margin-top: 15px;">
		<div class="col-sm-12">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.cities}" var="city">
					<tr>
						<td>${city.id}</td>
						<td>${city.name}</td>
						<td>
							<a href="javascript:;" onclick='delRow(${city.id})' class="btn btn-danger btn-sm">删除</a>
						</td>
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
		if(window.confirm('确定要删除这条记录吗?')) location.href='${pageContext.request.contextPath}/city/delete?id='+id;
	}
</script>
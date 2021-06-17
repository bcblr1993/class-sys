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
    <title>添加学生</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
	<style>
		.form-control{
			height: 30px;
		}
	</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-8">
			<form action="${pageContext.request.contextPath}/student/update" method="post">
				<div class="form-group">
					<label>名称:</label>
					<p class="form-control-static">${student.id}</p>
					<input type="hidden" name="id" value="${student.id}" class="form-control" >
				</div>
				<div class="form-group">
					<label>名称:</label>
					<input type="text" name="name" value="${student.name}" class="form-control" >
				</div>
				<div class="form-group">
					<label>生日:</label>
					<input type="text" name="bir" value="<fmt:formatDate value="${student.bir}" pattern="yyyy/MM/dd"/>" class="form-control" >
				</div>
				<div class="form-group">
					<label>QQ:</label>
					<input type="text" name="qq" value="${student.qq}" class="form-control" >

				</div>
				<div class="form-group">
					<label>Phone:</label>
					<input type="text" name="phone" value="${student.phone}" class="form-control">
				</div>
				<div class="form-group">
					<label for="clazz">选择班级-小组:</label>
					<select class="form-control" name="clazzGroupId" id="clazz">
						<c:forEach items="${requestScope.clazzAndGroups}" var="clazz">
							<c:forEach items="${clazz.groups}" var="group">
								<option value="${clazz.id}#${group.id}"
									<c:if test="${student.group.id == group.id}">
										selected
									</c:if>
								>${clazz.name}----${group.name}(${group.stuCounts}人)</option>
							</c:forEach>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="city">就业城市:</label>
					<select class="form-control" name="city.id" id="city">
						<c:forEach items="${requestScope.citys}" var="city">
							<option value="${city.id}"
								<c:if test="${student.city.id ==city.id}">
									selected
								</c:if>
							>${city.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>请选择标签:</label>
					<div class="checkbox">
						<c:forEach items="${requestScope.tags}" var="tag">
							<label style="margin-right: 5px;">

								<input type="checkbox" value="${tag.id}" name="tagIds"
									<c:forEach items="${student.tags}" var="stuTag">
									<c:if test="${stuTag.id == tag.id}">
										   checked
									</c:if>
									</c:forEach>
								>
									${tag.name}
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="form-group">
					<label>备注:</label>
					<div id="div1">
						${student.mark}
					</div>
					<input name="mark" style="display: none;" id="markContent"/>
				</div>
				<button type="submit" class="btn btn-info btn-block btn-sm">保存学生信息</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js"></script>
<script type="text/javascript">
	const E = window.wangEditor
	const editor = new E('#div1');
	editor.config.height = 250;
	editor.config.onchange = function (newHtml) {
		document.getElementById("markContent").value = newHtml;
	};
	editor.create()
</script>
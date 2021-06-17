<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>index.html</title>

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
            <form action="${pageContext.request.contextPath}/tag/save" method="post">
                <div class="form-group">
                    <label>标签名称:</label>
                    <input type="text" class="form-control" name="name"/>
                </div>
                <div class="form-group">
                    <label>标签类型:</label>
                    <select name="type" class="form-control">
                        <option value="班级">班级</option>
                        <option value="学生">学生</option>
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

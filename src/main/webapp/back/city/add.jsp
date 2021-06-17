<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
    <title>添加城市</title>
</head>
<body>
<div class="container-fluid">
    <div class="row" style="margin-top: 30px;">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/city/save" method="post">
                <div class="form-group">
                    <label>
                        城市名称:
                    </label>
                    <input type="text" class="form-control" name="name"/>
                </div>

                <input type="submit" class="btn btn-success btn-block btn-sm" value="提交"/>
                <input type="button" class="btn btn-info btn-block btn-sm" value="返回上级" onclick="history.go(-1);"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>
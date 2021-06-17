<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>index.html</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/statics/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <div class="row" style="margin-top: 20px;">
        <div class="col-sm-12">
            <a href="javascript:;"  class="btn btn-sm btn-info" id="refresh">开启自动刷新数据</a>
            <a href="javascript:;" class="btn btn-sm btn-danger" id="close">关闭自动刷新数据</a>
        </div>
    </div>
    <div class="row" style="margin-top: 10px;">
        <div class="col-sm-6">
            <div id="clazzChart" style="width: 600px;height:400px;"></div>
        </div>
        <div class="col-sm-6">
            <div id="tagType" style="width: 600px;height:400px;"></div>
        </div>
    </div>
</div>
</body>
</html>
<script src="${pageContext.request.contextPath}/back/statics/js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
<script>
    $(function(){
        var timeRef;

        //自动刷新
        $("#refresh").click(function(){
            timeRef =  setInterval(function () {
                showClazzAndTag();
           },3000);
        });

        //自动关闭
        $("#close").click(function () {
            clearInterval(timeRef);
        })

    })
</script>
<script>
    var clazzChart = echarts.init(document.getElementById('clazzChart'),'light');
    var tagType = echarts.init(document.getElementById('tagType'),'light');

    var option = {
        title: {
            text: '各班级学生数量'
        },
        tooltip: {},
        legend: {
            data:['学生数量']
        },
        xAxis: {
            //data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            data:[]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            //data: [5, 20, 36, 10, 10, 20]
            data:[]
        }],
    };

    // 使用刚指定的配置项和数据显示图表。
    clazzChart.setOption(option);
    clazzChart.showLoading();
    showClazzAndTag();//展示统计

    function showClazzAndTag(){
        $.get('${pageContext.request.contextPath}/getClazz').done(function (data) {
            clazzChart.hideLoading();
            // 填入数据
            clazzChart.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '销量',
                    data: data.data
                }]
            });
        });


        $.get('${pageContext.request.contextPath}/getTag').done(function (data) {
            tagType.setOption({
                title: {
                    text: '标签类型占比'
                },
                series : [
                    {
                        name: '标签类型占比',
                        type: 'pie',
                        radius: '70%',
                        data:data
                    }
                ]
            });
        });
    }
</script>
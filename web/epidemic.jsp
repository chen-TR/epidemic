<%--  Created by sibingmao  Date: 2020/2/24 15:34 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>疫情信息</title>
    <style type="text/css">
        #body1 {
            background-color: #10AEB5;
        }
    </style>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/bootstrap/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/respond.js"></script>
    <![endif]-->
</head>
<body id="body1">
<div class="container">
    <div class="row">
        <div class="col-md-12" style="background-color:#fff;margin-bottom: 5px;">
            <div id="myMap" style="height: 600px;"></div>
        </div>
    </div>
    <div class="row" style="height: 400px; overflow: auto;">
        <div class="col-md-16" style="background-color:#fff;">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                <tr>
                    <th>省份</th>
                    <th>确诊人数</th>
                    <th>疑似人数</th>
                    <th>隔离人数</th>
                    <th>治愈人数</th>
                    <th>死亡人数</th>
                </tr>
                </thead>
                <tbody id="tbody1">

                </tbody>
            </table>
        </div>
    </div>
    <div class="row" style="margin-top: 5px;">
        <div class="col-md-12">
            <div id="mycharts" style="height: 500px;border: 1px solid gray;background-color:#fff;"></div>
        </div>
    </div>
    <div class="row">
        <a href="login.jsp">登录</a>
    </div>
</div>

<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/echarts/echarts.js"></script>
<script type="text/javascript">
    $(function () {

        //定义个用来给表格中装载数据的函数
        var fillToTable = function (epidemics) {
            var tbody1 = $("#tbody1");
            tbody1.empty();
            $.each(epidemics, function (index, epidemic) {
                var tr = $("<tr>");
                var td = $("<td>");
                td.text(epidemic.provinceName);
                tr.append(td);

                td = $("<td>");
                td.html("" + epidemic.affirmedTotal + " <span class='small'>+" + epidemic.affirmed + "</span>");
                tr.append(td);

                td = $("<td>");
                td.html("" + epidemic.suspectedTotal + " <span class='small'>+" + epidemic.suspected + "</span>");
                tr.append(td);


                td = $("<td>");
                td.html("" + epidemic.isolatedTotal + " <span class='small'>+" + epidemic.isolated + "</span>");
                tr.append(td);

                td = $("<td>");
                td.html("" + epidemic.curedTotal + " <span class='small'>+" + epidemic.cured + "</span>");
                tr.append(td);

                td = $("<td>");
                td.html("" + epidemic.deadTotal + " <span class='small'>+" + epidemic.dead + "</span>");
                tr.append(td);

                tbody1.append(tr);
            });
        };
        //初始化图表
        var myCharts = echarts.init($("#mycharts").get(0));
        var option = {
            title: {
                text: "当日全国疫情柱状图",
                subtext: '2020-02-28'
            },
            grid: {
                show: true
            },
            legend: {
                data: ["2020-02-28"]
            }
            ,
            tooltip: {
                trigger: 'axis'
            }
            ,
            xAxis: {
                data: []
            }
            ,
            yAxis: {}
            ,
            series: [{
                type: 'bar',
                name: '2020-02-28',
                data: []
            }]
        };
        myCharts.setOption(option);
        //将服务器端返回的数据设置到图表上
        var fillToChart = function (epidemics) {
            var provinceNames = [];
            var affirmedTotal = [];
            $.each(epidemics, function (index, epidemic) {
                provinceNames.push(epidemic.provinceName);
                affirmedTotal.push(epidemic.affirmedTotal);
            });
            myCharts.setOption({
                xAxis: {
                    data: provinceNames
                },
                series: [{
                    data: affirmedTotal
                }]
            });
        };
        var myMap = echarts.init($("#myMap").get(0));
        //获取地图json数据，显示中国地图
        $.getJSON("${pageContext.request.contextPath}/echarts/china.json", {}, function (chinaJson) {
            echarts.registerMap("china", chinaJson);
            var option = {
                title: {
                    text: "2020-02-28 全国疫情分布图"
                },
                legend: {
                    data: ["累计确诊人数"]
                },
                tooltip: {},
                visualMap: {
                    type: 'piecewise',
                    min: 0,
                    max: 10000,
                    splitList:
                        [{
                            start: 1000,
                            end: 10000
                        }, {
                            start: 500,
                            end: 1000
                        }, {
                            start: 100,
                            end: 500
                        }, {
                            start: 0,
                            end: 100
                        }],
                    textStyle:
                        {
                            color: 'orange'
                        }
                },
                series: [
                    {
                        name: '累计确诊人数',
                        type: 'map',
                        mapType: 'china',
                        data: []
                    }
                ]
            };
            myMap.setOption(option);
        }, "json");
        //将数据填充到地图中
        var fillToMap = function (epidemics) {
            var data = [];
            $.each(epidemics, function (index, epidemic) {
                var obj = {};
                obj.name = epidemic.provinceName;
                obj.value = epidemic.affirmedTotal;
                data.push(obj);
            });
            myMap.setOption({
                series: [
                    {
                        name: '累计确诊人数',
                        type: 'map',
                        mapType: 'china',
                        data: data
                    }
                ]
            });
        };
        //发送请求获取最新疫情数据
        $.get("${pageContext.request.contextPath}/epidemicData/ajax/lastestData", {}, function (resp) {
            if (resp.code < 0) {
                alert(resp.msg);
            } else {
                fillToTable(resp.data);
                fillToChart(resp.data);
                fillToMap(resp.data);
            }
        }, "json");
    });
</script>
</body>
</html>

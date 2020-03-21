<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/2/27
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>疫情数据录入</title>
    <jsp:include page="../template/bootstrap_common.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="../bootstrap/datepicker/bootstrap-datepicker3.css">
</head>
<body>
<div class="container">
    <jsp:include page="../template/top.jsp"></jsp:include>
    <div class="row">
        <div class="col-md-3">
            <jsp:include page="../template/menu.jsp"></jsp:include>
        </div>
        <div class="col-md-9">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
            <li>数据录入</li>
        </ul>
        <div class="row">
            <div class="col-md-3 input-group date" id="datepicker" data-date-format="yyyy-mm-dd">
                <div class="input-group-addon">数据日期</div>
                <input class="form-control" size="16" type="text" value="" readonly id="dataDate">
                <div class="input-group-addon"><span class="add-on glyphicon glyphicon-calendar"></span></div>
            </div>
        </div>
            <br>
        <div class="row">
            <table class="table table-striped table-hover table-bordered">
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
                <tbody id="body1">
                <tr>
                    <td>湖北</td>
                    <td><input type="text " name="affirmed" size="4" maxlength="4" class="form-control"></td>
                    <td><input type="text " name="suspected" size="4" maxlength="4" class="form-control"></td>
                    <td><input type="text " name="isolated" size="4" maxlength="4" class="form-control"></td>
                    <td><input type="text " name="cured" size="4" maxlength="4" class="form-control"></td>
                    <td><input type="text " name="dead" size="4" maxlength="4" class="form-control"></td>
                </tr>
                </tbody>
            </table>
        </div>
            <div class="row">
              <div id="msg"></div>
            </div>
        </div>
    </div>
    <div class="row">第三行</div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script> <!--1.x支持所有浏览器，2.x不支持所有-->
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/datepicker/bootstrap-datepicker.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
<script type="text/javascript">
    var provinces=null;
    $(function () {

        //设置日期输入框的初始值和取值范围
        var datepicker = $("#datepicker");<!--创建函数，调用-->
        datepicker.datepicker({
            language: 'zh-CN',
            autoclose: true
        });
        var current = new Date();
        datepicker.datepicker("setDate", current);
        var date1=new Date();
       date1.setDate(current.getDate()-7);
       datepicker.datepicker("setStartDate",date1);
       datepicker.datepicker("setEndDate",current);
       //给日期选择框设置事件处理函数
        datepicker.datepicker().on("changeDate", loadProvinceList);
       //装载省份列表
        loadProvinceList();
    });
    function  loadProvinceList() {
        //清空表格
        var tbody1=$("#body1");
        tbody1.empty();
        //获取当前日期框的值
       var date=$("#dataDate").val();
        //从服务器获取还没录入数据的省份列表
        $.get("${pageContext.request.contextPath}/province/ajax/noDateList",{date:date},function (resp) {
            if (resp.code<0){
                alert(resp.msg);
            } else {
                fillProvinceToTable(resp.date);
            }
        },"json");
    }

    function  fillProvinceToTable(array) {
        if (array && array.length>0){
            provinces=array;
            //填充到表格中
            var  tbody1=$("#body1");
            $.each(array,function (index,province) {
                console.info(province.provinceName)
                var  tr=$("<tr>");
                var  td=$("<td>");
                td.text(province.provinceName);
                tr.append(td);

                td=$("<td>");
                td.html('<input type="text " name="affirmed" size="4" maxlength="4" class="form-control">');
                tr.append(td);

                td=$("<td>");
                td.html('<input type="text " name="suspected" size="4" maxlength="4" class="form-control">');
                tr.append(td);

                td=$("<td>");
                td.html('<input type="text " name="isolated" size="4" maxlength="4" class="form-control">');
                tr.append(td);

                td=$("<td>");
                td.html('<input type="text " name="cured" size="4" maxlength="4" class="form-control">');
                tr.append(td);

                td=$("<td>");
                td.html('<input type="text " name="dead" size="4" maxlength="4" class="form-control">');
                tr.append(td);

                tbody1.append(tr);
            });

        }else {
            $("#msg").html("本日所有省份都已经录入了数据！")

        }

    }
</script>
</body>
</html>
</html>

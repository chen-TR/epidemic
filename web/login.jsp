<%--  Created by sibingmao  Date: 2020/2/25 11:39 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>
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
        <div class="col-md-4 col-md-offset-4">
            <div style="height: 200px;"></div>
            <h1>登录系统</h1>
            <form action="${pageContext.request.contextPath}/user/login" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-md-2 control-label" for="account">账号:</label>
                    <div class="col-md-8"><input type="text" name="account" id="account" class="form-control"></div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-md-2 control-label">密码:</label>
                    <div class="col-md-8">
                        <input type="password" name="password" id="password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-2"><input type="submit" value="登录" class="btn btn-primary"></div>
                </div>
            </form>
        </div>
        <c:if test="${not empty msg}">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="alert alert-danger alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
                            ${msg}</div>
                </div>
            </div>
        </c:if>
    </div>
</div>
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ctr
  Date: 2020/2/26
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div id="contanier">
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        账号: <input type="text" name="account"> <br>
        密码: <input type="password" name="password"> <br>
        <input type="submit" value="登录">
    </form>
    ${msg}
</div>
</body>
</html>

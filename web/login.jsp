<%--
  Created by IntelliJ IDEA.
  User: elephant
  Date: 16/7/4
  Time: 下午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#deb887">
<br>
<img src="imgs/logo1.gif">
<hr>
<center>
    用户登录<br><br>
    <form action="loginclservlet" method="post">
        用户名 ：<input type="text" name="username"><br><br>
        密码 ：<input type="password" name="password"><br><br>
        <input type="submit" value="登陆">
        <input type="reset" value="重置">
    </form>
</center>
<hr>
<img src="imgs/logo1.gif">
</body>
</html>

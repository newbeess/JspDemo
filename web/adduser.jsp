<%--
  Created by IntelliJ IDEA.
  User: elephant
  Date: 16/7/7
  Time: 下午12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#deb887">
<br>
<img src="imgs/logo1.gif">
<hr>
<center>

  添加用户<br><br>
  <form action="updateUser?flag=useradd" method="post">
    用户名 ：<input type="text" name="username"><br><br>
    密码 ：<input type="password" name="password"><br><br>
    邮箱：<input type="text" name="mail"><br><br>
    grade：<input type="text" name="grade"><br><br>
    <input type="submit" value="添加">
    <input type="reset" value="重置">
  </form>
</center>
<hr>
<img src="imgs/logo1.gif">
</body>

</body>
</html>

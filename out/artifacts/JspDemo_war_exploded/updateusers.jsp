<%--
  Created by IntelliJ IDEA.
  User: elephant
  Date: 16/7/7
  Time: 上午10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title></title>
</head>
<body bgcolor="#deb887">
<br>
<img src="imgs/logo1.gif">
<hr>
<center>
  修改用户<br><br>

  <%--
  <%
    int id=Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String mail = request.getParameter("mail");
    Integer grade = Integer.parseInt(request.getParameter("grade"));
  %>
  --%>

  <form action="usersclservlet?flag=useradd" method="post">
    ID:<input readonly type="text" name="id" value=${param.id}><br><br>
    用户名 ：<input readonly type="text" name="username" value=${param.name}><br><br>
    密码 ：<input type="password" name="password" value=${param.password}><br><br>
    邮箱：<input type="text" name="mail" value=${param.mail}><br><br>
    grade：<input type="text" name="grade" value=${param.grade}><br><br>
    <input type="submit" value="修改">
    <input type="reset" value="重置">
  </form>
</center>
<hr>
<img src="imgs/logo1.gif">
</body>
</html>

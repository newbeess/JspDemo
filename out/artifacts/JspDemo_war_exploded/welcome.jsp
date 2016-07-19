<%@ page import="info.fuchao.model.UserBeanCL" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="info.fuchao.model.UserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: elephant
  Date: 16/7/4
  Time: 下午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <img src="imgs/logo1.gif">
    <script type="text/javascript">
        <!--
        function abc() {
            return window.confirm("确认删除");
        }
        -->
    </script>
</head>
<body bgcolor="#deb887">
<a href="login.jsp">返回重新登录</a>

<hr>
<center>
    <h1>
        欢迎界面JSTL
    </h1>

    <c:if test="${username==null}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>

    <br>欢迎你${username}
    <table border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PASSWORD</th>
            <th>MAIL</th>
            <th>GRADE</th>
            <th>修改用户</th>
            <th>删除用户</th>

        </tr>
        <c:forEach items="${al}" var="ub">

            <tr>
                <td>${ub.id}
                </td>
                <td>${ub.user}
                </td>
                <td>${ub.password}
                </td>
                <td>${ub.mail}
                </td>
                <td>${ub.grade}
                </td>
                <td>
                    <a href="updateusers.jsp?id=${ub.id}&name=${ub.user}&password=${ub.password}&mail=${ub.mail}&grade=${ub.grade}">修改用户</a>
                </td>
                <td><a onclick="return abc()" href="usersclservlet?flag=delUser&id=${ub.id}">删除用户</a></td>

            </tr>
        </c:forEach>
    </table>

    <c:if test="${pn>1}">
        <a href=usersclservlet?flag=fenye&pageNow=${pn-1}>上一页</a>
    </c:if>

    <c:forEach var="i" begin="1" end="${pc}">
        <a href=usersclservlet?flag=fenye&pageNow=${i}> ${i} </a>
    </c:forEach>
    <c:if test="${pn<pc}">
        <a href=usersclservlet?flag=fenye&pageNow=${pn+1}>下一页</a>
    </c:if>
    <hr>
</center>
<img src="imgs/logo1.gif">

</body>
</html>

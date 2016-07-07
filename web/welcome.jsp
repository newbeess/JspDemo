<%@ page import="info.fuchao.model.UserBeanCL" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="info.fuchao.model.UserBean" %>
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
    function abc(){
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
    欢迎界面
</h1>

<%
    // 获取 Session
    HttpSession session1=request.getSession();
    String name=(String)session1.getAttribute("username");
    if (name==null){
        response.sendRedirect("login.jsp");
    }
    String id=session1.getId();
    // 获取，欢迎界面所需的数据，展示数据
    ArrayList al = (ArrayList) request.getAttribute("al");
    int pageCount = (Integer) request.getAttribute("pc");
    int pageNow=(Integer) request.getAttribute("pn");
%>
<br>欢迎你<%=name%>,SessionId=<%=id%>

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
    <%
        UserBean ub;
        for (int i = 0; i < al.size(); i++) {
            ub = (UserBean) al.get(i);
    %>
    <tr>
        <td><%=ub.getId()%>
        </td>
        <td><%=ub.getUser()%>
        </td>
        <td><%=ub.getPassword()%>
        </td>
        <td><%=ub.getMail()%>
        </td>
        <td><%=ub.getGrade()%>
        </td>
        <td><a href="updateusers.jsp?id=<%=ub.getId()%>&name=<%=ub.getUser()%>&password=<%=ub.getPassword()%>&mail=<%=ub.getMail()%>&grade=<%=ub.getGrade()%>">修改用户</a></td>
        <td><a onclick="return abc()" href="usersclservlet?flag=delUser&id=<%=ub.getId()%>">删除用户</a> </td>

    </tr>
    <%
        }
    %>
</table>

<%
    if (pageNow != 1)
        out.println(" <a href=usersclservlet?flag=fenye&pageNow=" + (pageNow - 1) + ">上一页</a>");

    for (int i = 1; i <= pageCount; i++) {
        out.println(" <a href=usersclservlet?flag=fenye&pageNow=" + i + ">" + i + "</a>");

    }
    if (pageNow != pageCount)
        out.println(" <a href=usersclservlet?flag=fenye&pageNow=" + (pageNow + 1) + ">下一页</a>");
%>
<hr>
</center>
<img src="imgs/logo1.gif">

</body>
</html>

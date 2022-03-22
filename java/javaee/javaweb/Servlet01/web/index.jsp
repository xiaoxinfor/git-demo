<%@ page import="java.util.List" %>
<%@ page import="com.javasm.bean.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/7
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    //获取UsersGetServlet中传过来的请求域
    Object objList = request.getAttribute("Users");
    List<User> list = objList != null ? (List<User>) objList : null;
%>
<table border="1px">
    <tr>
        <th>账号</th>
        <th>密码</th>
    </tr>
    <%
        if (list != null) {
            //循环取出集合中的值
            for (User user : list) {
                out.write("<tr>");
                out.write("<td> " + user.getAct() + "</td>");
                out.write("<td> " + user.getPwd() + "</td>");
                out.write("</tr>");
            }
        } else {
            out.write("<tr><td colspan='2' align='center'>暂无数据</td></tr>");
        }
    %>
</table>

<%-- jspt --%>
<br>
<table border="1px">
    <tr>
        <th>账号</th>
        <th>密码</th>
    </tr>
    <c:forEach items="${Users}" var="user">
        <tr>
            <td>${user.getAct()}</td>
            <td>${user.getPwd()}</td>
        </tr>
    </c:forEach>
</table>

    <c:forEach items="${User}" var="user">
        <c:if test="${user.getAct}"></c:if>
    </c:forEach>
</body>
</html>

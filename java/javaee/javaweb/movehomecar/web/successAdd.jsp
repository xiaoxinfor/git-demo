<%@ page import="com.javasm.bean.MoveBooking" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/10
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #box{
            width: 600px;
            height: 200px;
            margin: 0px auto;
            border: solid red;
        }
        span{
            font-family: "楷体";
            font-size: 25px;
            color: red;
        }
    </style>
</head>
<body>
<div id="box">
    <span>预约成功!!</span>
    <span>您的预约信息为：</span><br><br><br>
    <table border="1px">
        <tr>
            <th>起始地区</th>
            <th>车型</th>
            <th>搬家日期</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>状态</th>
        </tr>
        <c:if test="${mession == '预约失败'}">
            <tr>
                <td>预约失败</td>
            </tr>
        </c:if>
        <c:if test="${mession != '预约失败'}">
            <tr>
                <td>${booking.getArea()}</td>
                <td>${booking.getCartype()}</td>
                <td>${booking.getMovedate()}</td>
                <td>${booking.getContact()}</td>
                <td>${booking.getPhone()}</td>
                <td>未处理</td>
            </tr>
        </c:if>
    </table>
    <a href="frist.html">返回首页</a>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/11
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #dd{
            display: none;
        }
    </style>
</head>
<body>
    <h2>顺风搬家预约登记</h2>
    <form action="/move/change.do">
        <input name="id" value="${book.getId()}" id="dd">
        起始地区：<a>${book.getArea()}</a><br>
        所用车型：<a>${book.getCartype()}</a><br>
        搬家日期：<a>${book.getMovedate()}</a><br>
        联系人：<a>${book.getContact()}</a><br>
        联系电话：<a>${book.getPhone()}</a><br>
        状态修改：
            <select name="state">
                <option value="1">已派车</option>
                <option value="2">已结束</option>
            </select><br>
        <button type="submit">处理</button>
    </form>
</body>
</html>

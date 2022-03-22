<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/11
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #box {
            width: 690px;
            height: 350px;
            margin: 200px auto;

        }

        h2 {
            font-family: "楷体";
            font-size: 50px;
        }
    </style>
</head>
<body>
<div id="box">
    <h2 style="color: red">顺风搬家预约查询：</h2>

    <table border="1px">
        <tr>
            <th>起始地区</th>
            <th>所用车型</th>
            <th>搬家日期</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${bookList}" var="list">
            <tr>
                <th>${list.getArea()}</th>
                <th>${list.getCartype()}</th>
                <th>${list.getMovedate()}</th>
                <th>${list.getContact()}</th>
                <th>${list.getPhone()}</th>
                <th>${list.getState() == 0 ? "未处理" : (list.getState() == 1 ? "以派车" : "以结束")}</th>
                <th>
                    <a href="/move/get?id=${list.getId()}">处理</a>
                    <a href="/move/del.do?id=${list.getId()}">删除</a>
                </th>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" align="center">
                <a href="/move/page.do?nowPage=1">首页</a>
                <a href="/move/page.do?nowPage=${page.nowPage - 1}">上一页</a>
                <a href="/move/page.do?nowPage=${page.nowPage + 1}">下一页</a>
                <a href="/move/page.do?nowPage=${page.sunPage}">尾页</a>
            </td>
        </tr>
        <tr>
            <td colspan="7" align="center">
                <form action="/move/page.do">
                    输入车型：
                    <select name="cartype">
                        <option value="金杯">金杯</option>
                        <option value="皮卡">皮卡</option>
                        <option value="1041货车">1041货车</option>
                        <option value="厢式货车">厢式货车</option>
                    </select>
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>
    </table>
</div>

</body>
</html>

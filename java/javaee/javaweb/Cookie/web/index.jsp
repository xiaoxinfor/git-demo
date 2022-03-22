<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/12
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <form action="/cookie.do">
      账号：<input type="text" name="act"><br>
      密码：<input type="password" name="pwd"><br>
      <input type="checkbox" name="remeber">记住密码  <a href="">忘记密码</a><br>
      <button type="submit">登录</button>
    </form>
  </div>
  </body>
</html>

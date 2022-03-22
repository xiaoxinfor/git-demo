<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/14
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>

  </head>
  <body>
  <form action="/reg.do" id="userForm">
      账号：<input type="text" name="act" id="a"><span id="sp" style="color: red"></span>
      <br>
      密码：<input type="text" name="pwd">
      <br>
      <button type="button" id = "btn">注册</button>
  </form>
  <script>
      document.getElementById("a").onblur = function(){
          //创建异步对象
          var xhr = new XMLHttpRequest();
          //初始化请求参数
          xhr.open("get","/yan.do?act=" + document.getElementById("a").value,true)
          //发起请求
          xhr.send();
          //绑定事件
          xhr.onreadystatechange = function () {
              if (xhr.readyState == 4 && xhr.status == 200){
                  //获取服务器发过来的响应
                  var date = xhr.responseText;
                  document.getElementById("sp").innerText = date;
              }
          }
      }
      var af = document.getElementById("a");
      var spE = document.getElementById("sp");
      af.onfocus = function () {
          if (spE.innerText != ""){
              af.value = "";
          }
          spE.innerText = "";
      }
      var btnElt = document.getElementById("btn");
      btnElt.onclick = function () {
          if (spE.innerText == "" && af.value != ""){
              //提交表单
              //先获取表单对象
              var userFormElt = document.getElementById("userForm");
              userFormElt.submit();//提交
          }
      }
  </script>
  </body>
</html>

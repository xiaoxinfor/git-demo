<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/10
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      #box1{
        width: 600px;
        height: 300px;
        margin: 0px auto;
        border: #00FFFF solid;
      }
      div{
        margin-top: 10px;
        margin-left: 10px;
      }
      a{
        font-size: 30px;
        margin-left: 100px;
      }
    </style>
  </head>
  <body>
  <div id="box1">
    <a>顺风搬家预约登记</a>
    <form  action="/move/yue">
      <div>
        起始地区：
        <select name="area">
          <option value="东城区">东城区</option>
          <option value="西城区">西城区</option>
          <option value="南城区">南城区</option>
          <option value="北城区">北城区</option>
        </select>
      </div>

      <div>
        所用车型：
        <input type="radio" name="cartype" value="金杯" />金杯
        <input type="radio" name="cartype" value="皮卡" />皮卡
        <input type="radio" name="cartype" value="1041货车" />1041货车
        <input type="radio" name="cartype" value="厢式货车" />厢式货车
      </div>
      <div>
        搬家日期：<input type="text" name="movedate" /><span style="color: red;">日期格式如：0000-00-00</span>
      </div>
      <div>
        联系人：<input type="text" name="contact" />
      </div>
      <div>
        联系电话：<input type="text" name="phone" />
      </div>
      <div>
        <input type="submit" value="预约登记"/>
      </div>
    </form>
  </div>
  </body>
</html>

package com.javapractice.control;

import com.alibaba.fastjson.JSONObject;
import com.javapractice.bean.Area;
import com.javapractice.service.ProvinceService;
import com.javapractice.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-19:34
 * @Since:jdk1.8
 * @Description:
 */

public class ProvinceServlet extends HttpServlet {
    private ProvinceService provinceService = new ProvinceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");

        //查询所有的省份
        List<Area> list = provinceService.allProvince();
        //通过fastJson插件将list转换为json格式
        String jsonString = JSONObject.toJSONString(list);
        //将jsonString发送到浏览器
        PrintWriter out = resp.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }
}

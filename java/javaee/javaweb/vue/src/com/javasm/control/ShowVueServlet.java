package com.javasm.control;

import com.alibaba.fastjson.JSONObject;
import com.javasm.bean.VueTb;
import com.javasm.service.VueService;
import com.javasm.service.impl.VueServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-19:34
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/showAll.do")
public class ShowVueServlet extends HttpServlet {
    private VueService vueService = new VueServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        //查询表中所有信息
        List<VueTb> list = vueService.selectAll();
        //将list转为json 格式
        String jsonString = JSONObject.toJSONString(list);
        //发送到浏览器
        PrintWriter out = resp.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }
}

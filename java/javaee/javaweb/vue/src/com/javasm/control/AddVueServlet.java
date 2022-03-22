package com.javasm.control;

import com.alibaba.fastjson.JSON;
import com.javasm.bean.VueTb;
import com.javasm.service.VueService;
import com.javasm.service.impl.VueServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-20:20
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/add.do")
public class AddVueServlet extends HttpServlet {
    private VueService vueService = new VueServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf8");
        resp.setContentType("application/json;charset=utf-8");
        StringBuffer content = new StringBuffer("");
        String line = null;

        //获取请求体数据
        BufferedReader br = req.getReader();
        line = br.readLine();
        //乱码？？
        line = new String(line.getBytes(), "utf-8");

        //将json字符串转为java对象
        VueTb vueTb = JSON.parseObject(line, VueTb.class);
        System.out.println(line);
        //添加到数据库
        int i = vueService.addVue(vueTb);
        if (i > 0) {
            //添加成功
            PrintWriter out = resp.getWriter();
            out.write("success");
            out.flush();
            out.close();
        }
    }
}


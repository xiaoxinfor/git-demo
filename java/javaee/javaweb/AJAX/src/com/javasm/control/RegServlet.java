package com.javasm.control;

import com.javasm.dao.RegDao;
import com.javasm.dao.impl.RegDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-16:02
 * @Since:jdk1.8
 * @Description:
 */
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String act = req.getParameter("act");
        String pwd = req.getParameter("pwd");
        RegDao regDao = new RegDaoImpl();
        int a = regDao.addUser(act,pwd);
        if (a>0){
            out.write("注册成功");
        }
    }
}

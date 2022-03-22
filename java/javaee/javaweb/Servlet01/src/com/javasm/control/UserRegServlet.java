package com.javasm.control;

import com.javasm.bean.User;
import com.javasm.dao.UserDao;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/7-22:00
 * @Since:jdk1.8
 * @Description:
 */
public class UserRegServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.【调用请求对象】读取【请求头】参数信息，得到用户的信息信息
        String act = req.getParameter("act");
        String pwd = req.getParameter("pwd");
        User user = new User(act,pwd);
        //将浏览器传过来的数据添加到数据库
        int i = userService.reg(user);
        //调用相应对象，将处理结果以二进制写入到响应体
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (i>0){
            resp.sendRedirect("/yi/reg.html");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
        out.flush();
        out.close();
    }
}

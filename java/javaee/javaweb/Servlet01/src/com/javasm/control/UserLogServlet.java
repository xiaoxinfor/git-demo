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
 * @Date：2022/3/8-11:48
 * @Since:jdk1.8
 * @Description:
 */
public class UserLogServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用请求对象对请求体使用utf-8字符集进行重新编辑
        req.setCharacterEncoding("utf-8");
        //拿到浏览器发过来的请求
        String act = req.getParameter("act");
        String pwd = req.getParameter("pwd");
        //在数据库中查找
        User user = userService.log(act);
        String getPwd = user.getPwd();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (user != null) {
            if (pwd.equals(getPwd)){//登录成功
                //获取session对象
                req.getSession().setAttribute("user",act);
                out.print("<font style='color:red;font-size:40'>登录成功</font>");
                resp.sendRedirect("/yi/success.html");
            }else {
                out.print("<h1>密码错误</h1>");
                resp.sendRedirect("/yi/reg.html");
            }
        } else {
            out.print("<h1>账号错误</h1>");
            resp.sendRedirect("/yi/reg.html");
        }
    }
}

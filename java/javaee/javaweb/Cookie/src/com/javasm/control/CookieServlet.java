package com.javasm.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/12-14:49
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/cookie.do")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //账号
        String act = req.getParameter("act");
        //密码
        String pwd = req.getParameter("pwd");
        //是否记住密码
        String remeber = req.getParameter("remeber");

        //获取浏览器发过来的Cookie
        Cookie[] cookies = req.getCookies();
        Boolean flag = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("act")){
                flag =true;
                break;
            }
        }

        if (act.equals("haha") && pwd.equals("123")){//登录成功
            if ("on".equals(remeber)){
                //记住密码，存入Cookie
                //创建Cookie对象
                Cookie cookie = new Cookie("act","haha");
                Cookie cookie1 = new Cookie("pwd","123");
                //设置Cookie有效期
                cookie.setMaxAge(60*60*5);
                cookie1.setMaxAge(60*60*5);
                //将Cookie发送到浏览器上
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
            }
            resp.getWriter().write("登录成功");
        }else if(flag){
            resp.getWriter().write("登录成功");
        } else {
            //登陆失败
            resp.getWriter().write("登录失败");
        }
    }
}

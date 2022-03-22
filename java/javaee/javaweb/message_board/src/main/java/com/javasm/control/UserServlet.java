package com.javasm.control;

import com.javasm.bean.User;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/17-22:32
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/user.do")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userLog(req,resp);
    }

    /**
     * 用户登录
     *
     * @param req
     * @param resp
     */
    private void userLog(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uName = req.getParameter("name");
        String uPassWord = req.getParameter("pwd");
        User user = userService.selectUser(uName);
        PrintWriter out = resp.getWriter();
        if (user != null){//姓名正确
            if (uPassWord.equals(user.getUPassWord())){
                //密码正确
                HttpSession session = req.getSession();//获取session，没有则新建
                session.setAttribute("userName",uName);
                out.write("true");
            }else {
                //密码错误
                out.write("pwdfalse");
            }
        }else {//没有此账号
            out.write("false");
        }
        out.flush();
        out.close();
    }
}

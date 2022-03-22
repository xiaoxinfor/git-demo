package com.javasm.control;

import com.javasm.bean.User;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-13:31
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(name = "get",urlPatterns = "/get")
public class UsersGetServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.getUsers();
        //向请求域中绑定数据
        req.setAttribute("Users",list);
        //请求转发
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}

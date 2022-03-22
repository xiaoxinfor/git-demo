package com.javasm.control;

import com.javasm.bean.MoveBooking;
import com.javasm.bean.PageInfo;
import com.javasm.bean.Users;
import com.javasm.service.MoveBookingService;
import com.javasm.service.UsersService;
import com.javasm.service.impl.MoveBookingServiceImpl;
import com.javasm.service.impl.UsersServiceImpl;

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
 * @Date：2022/3/10-22:34
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/userlog.do")
public class UsersServlet extends HttpServlet {
    private UsersService usersService = new UsersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到浏览器发过来的登录请求
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        //将拿到的信息在数据库中查找
        Users users = usersService.userLog(userName);
        String getPwd = users.getUserPwd();
        if (userPwd.equals(getPwd)){//登录成功,分页查询预约表里的所有数据
            req.getSession().setAttribute("SUCCESS",req.getSession().getId());
            //重定向
            resp.sendRedirect("/move/page.do");
        }else {
            //登录失败
        }
    }
}

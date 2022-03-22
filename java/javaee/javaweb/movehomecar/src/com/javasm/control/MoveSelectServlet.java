package com.javasm.control;

import com.javasm.bean.MoveBooking;
import com.javasm.service.MoveBookingService;
import com.javasm.service.impl.MoveBookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/11-20:29
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/get")
public class MoveSelectServlet extends HttpServlet {
    private MoveBookingService moveBookingService = new MoveBookingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Integer id = Integer.valueOf(idStr);
        //根据id查找该条数据
        MoveBooking moveBooking = moveBookingService.getMove(id);
        //存入请求域
        req.setAttribute("book",moveBooking);
        //请求转发
        req.getRequestDispatcher("changeMove.jsp").forward(req,resp);
    }
}

package com.javasm.control;

import com.javasm.bean.MoveBooking;
import com.javasm.bean.PageInfo;
import com.javasm.service.MoveBookingService;
import com.javasm.service.impl.MoveBookingServiceImpl;

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
 * @Date：2022/3/11-13:47
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/page.do")
public class PageInfoServlet extends HttpServlet {
    private MoveBookingService bookingService = new MoveBookingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前页
        String nowPageStr = req.getParameter("nowPage");
        String pageSizeStr = req.getParameter("pageSize");
        String name = req.getParameter("cartype");

        PageInfo pageInfo = bookingService.selectPageMove(nowPageStr,pageSizeStr,name);
        List<MoveBooking> list = pageInfo.getDataList();
        MoveBooking moveBooking = new MoveBooking();
        //将数据存入请求域
        req.setAttribute("bookList",list);
        req.setAttribute("page",pageInfo);
        //请求转发
        req.getRequestDispatcher("logSuccess.jsp").forward(req,resp);
    }
}

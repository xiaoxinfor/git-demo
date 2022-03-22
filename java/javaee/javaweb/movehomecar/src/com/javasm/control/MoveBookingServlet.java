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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-20:41
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/yue")
public class MoveBookingServlet extends HttpServlet {
    private MoveBookingService service = new MoveBookingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到浏览器请求的数据
        String area = req.getParameter("area");
        String cartype = req.getParameter("cartype");
        String date = req.getParameter("movedate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date movedate = null;
        try {
            movedate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String contact = req.getParameter("contact");
        String phone = req.getParameter("phone");

        //创建MoveBookingServlet对象
        MoveBooking booking = new MoveBooking(area,cartype,movedate,contact,phone);

        //将信息存入数据库
        int success = service.addMove(booking);
        if (success == 1){
            //将信息存储在session作用域
            req.getSession().setAttribute("booking",booking);
            //重定向
            resp.sendRedirect("successAdd.jsp");
        }else {
            req.setAttribute("mession","预约失败");
            //请求转发
            req.getRequestDispatcher("successAdd.jsp").forward(req,resp);
        }
    }
}

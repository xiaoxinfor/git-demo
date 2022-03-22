package com.javasm.control;

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
 * @Date：2022/3/11-21:07
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/change.do")
public class ChangeServlet extends HttpServlet {
    private MoveBookingService moveBookingService = new MoveBookingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String stateStr = req.getParameter("state");
        Integer id = Integer.valueOf(idStr);
        Integer state = Integer.valueOf(stateStr);
        //根据id修改状态
        int i = moveBookingService.change(id,state);
        if (i>0){
            //重定向到logSuccess.jsp
            resp.sendRedirect("logSuccess.jsp");
        }
    }
}

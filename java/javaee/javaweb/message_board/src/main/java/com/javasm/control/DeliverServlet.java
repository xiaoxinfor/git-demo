package com.javasm.control;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.javasm.bean.Deliver;
import com.javasm.service.DeliverService;
import com.javasm.service.impl.DeliverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-16:42
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/deliver.do")
public class DeliverServlet extends HttpServlet {
    private DeliverService deliverService = new DeliverServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getDeliver(req,resp);
    }

    private void getDeliver(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        PageInfo<Deliver> selectDel = deliverService.selectDel(pageNum,pageSize);
        String jsonString = JSONObject.toJSONString(selectDel);
        //将JSOn数据发送给前端页面
        PrintWriter out = resp.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }
}

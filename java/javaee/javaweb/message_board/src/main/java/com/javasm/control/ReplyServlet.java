package com.javasm.control;

import com.alibaba.fastjson.JSONObject;
import com.javasm.bean.Reply;
import com.javasm.service.ReplyService;
import com.javasm.service.impl.ReplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-21:24
 * @Since:jdk1.8
 * @Description:
 */
public class ReplyServlet extends HttpServlet {
    private ReplyService replyService = new ReplyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dIdStr = req.getParameter("dId");
        List<Reply> reply = replyService.selectSomeReply(dIdStr);
        String jsonString = JSONObject.toJSONString(reply);
        //将JSOn数据发送给前端页面
        PrintWriter out = resp.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }
}

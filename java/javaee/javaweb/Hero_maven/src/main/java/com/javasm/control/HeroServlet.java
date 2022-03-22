package com.javasm.control;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.javasm.bean.Hero;
import com.javasm.bean.HeroType;
import com.javasm.bean.vo.HeroTypeInfo;
import com.javasm.service.HeroService;
import com.javasm.service.impl.HeroServiceImpl;
import com.javasm.utils.DataConvert;
import com.javasm.utils.DataConvertEntity;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/19-10:42
 * @Since:jdk1.8
 * @Description:
 */
@WebServlet(urlPatterns = "/hero.do")
public class HeroServlet extends HttpServlet {
    private HeroService heroService = new HeroServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取method
        String method = req.getParameter("method");
        switch (method){
            case "showHeroByPage":
                //分页查询
                showHeroByPage(req,resp);
                break;
            case "showHeroType":
                //查询所有的英雄类型（添加修改）
                showHeroType(req,resp);
                break;
            case "saveHero":
                //添加英雄信息
                addHero(req,resp);
                break;
            case "updateHero":
                //修改英雄信息
                updateHero(req,resp);
                break;
            case "deleteHero":
                //删除英雄信息
                deleteHero(req,resp);
                break;
        }
    }

    /**
     * 删除英雄信息
     *
     * @param req
     * @param resp
     */
    private void deleteHero(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String heroIdStr = req.getParameter("heroId");
        Integer heroId = DataConvert.stringConvertInteger(heroIdStr);
        int i = heroService.deleteHero(heroId);
        PrintWriter out = resp.getWriter();
        if (i>0){
            out.write("true");
        }else {
            out.write("false");
        }
        out.flush();
        out.close();
    }

    /**
     * 修改英雄信息
     *
     * @param req
     * @param resp
     */
    private void updateHero(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Class<Hero> heroClass = Hero.class;
        Hero hero = DataConvertEntity.requestDataConvertEntity(parameterMap,heroClass);
        int integer = heroService.updateHero(hero);
        PrintWriter out = resp.getWriter();
        if (integer>0){
            out.write("true");
        }else {
            out.write("false");
        }
        out.flush();
        out.close();
    }

    /**
     * 添加英雄信息
     *
     * @param req
     * @param resp
     */
    private void addHero(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Class<Hero> heroClass = Hero.class;
        Hero hero = DataConvertEntity.requestDataConvertEntity(parameterMap,heroClass);
        Integer integer = heroService.addHero(hero);
        PrintWriter out = resp.getWriter();
        if (integer>0){
            out.write("true");
        }else {
            out.write("false");
        }
        out.flush();
        out.close();
    }

    /**
     * 查询英雄类型
     *
     * @param req
     * @param resp
     */
    private void showHeroType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<HeroType> list = heroService.selectHeroType();
        //将得到的数据转为JSON
        String jsonString = JSONObject.toJSONString(list);
        //将JSOn数据发送给前端页面
        PrintWriter out = resp.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }

    /**
     * 分页查询
     * @param req
     * @param resp
     */
    private void showHeroByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取分页数据
        String nowPage = req.getParameter("pageNum");//当前页
        String pageSize = req.getParameter("pageSize");//一页显示多少
        String heroName = req.getParameter("heroName");
        String[] dates = req.getParameterValues("date");
        String beginDate = null;
        String endDate = null;
        if (dates != null && dates.length == 2) {
            beginDate = dates[0];
            endDate = dates[1];
        }

        //查询分页数据
        PageInfo<HeroTypeInfo> heroByPage = heroService.selectHeroByPage(nowPage, pageSize,heroName,beginDate,endDate);
        //将得到的数据转为JSON
        String jsonString = JSONObject.toJSONString(heroByPage);
        //将JSOn数据发送给前端页面
        PrintWriter out = resp.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
    }
}

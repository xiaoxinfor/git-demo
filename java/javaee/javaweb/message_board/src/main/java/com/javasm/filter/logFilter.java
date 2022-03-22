package com.javasm.filter;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-10:30
 * @Since:jdk1.8
 * @Description:
 */
public class logFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //获取请求路径
        String path = request.getRequestURI();
        System.out.println(path);
        HttpSession session = request.getSession();
        Object userName = session.getAttribute("userName");
        //登录界面，通过登录界面取查询用户的servlet，已经登录了的放行
        if ("/log.jsp".equals(path) || "/user.do".contains(path) || userName != null){
            //放行
            chain.doFilter(request,response);
        }else {
            //重定向
            response.sendRedirect("log.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}

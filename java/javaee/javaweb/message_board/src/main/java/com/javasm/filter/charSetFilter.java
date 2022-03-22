package com.javasm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-16:11
 * @Since:jdk1.8
 * @Description:
 */
public class charSetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置request的编号格式
        request.setCharacterEncoding("utf-8");
        // 设置响应对象的编码格式
        response.setContentType("application/json;charset=utf-8");
        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

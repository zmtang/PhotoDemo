package com.example.photodemo.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * WebFilter-----servletNames : 指定过滤器将应用于哪些 Servlet。
 * @author zmt
 * @date 2019-05-15 09:40
 */
//@WebFilter(urlPatterns = {"/dev/*"},filterName = "myFilter",servletNames = "myServlet")
@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = config.getServletContext();
        System.err.println("进入过滤器 执行servlet之前 先过滤一下");
        filterChain.doFilter(servletRequest,servletResponse);// 放行
        System.err.println("执行结束了  返回数据前 再过滤一下");
    }

}

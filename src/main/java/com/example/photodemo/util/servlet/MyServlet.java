package com.example.photodemo.util.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author zmt
 * @date 2019-05-13 19:37
 */
@WebServlet(urlPatterns = "/myServlet/*",description = "servlet测试",name = "myServlet")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = -1488143137180925737L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        System.err.println("请求的： "+contextPath);
        String method = req.getMethod();
        System.err.println("method  "+method);
        String requestURI = req.getRequestURI();
        System.err.println("requestURI "+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.err.println("requestURL "+requestURL);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        // resp.setHeader("");
        PrintWriter out = resp.getWriter();
        out.println("<h1>这是一个Servlet方法</h1>");

        //  super.doPost(req, resp); //
    }
}

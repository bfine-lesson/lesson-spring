package com.lesson.spring.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ExampleServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //한번만 실행
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        //한번만 실행
    }
}

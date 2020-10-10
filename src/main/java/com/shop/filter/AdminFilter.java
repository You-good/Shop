package com.shop.filter;

import com.shop.bean.User;
import com.shop.controller.UserServlet;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {
    UserService userService = new UserServiceImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        User nowUser = (User) request.getSession().getAttribute("user");
        if (nowUser.getPermission()==0){
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setHeader("refresh", "3;url='" + request.getContextPath() + "/index.jsp'");
            response.getWriter().write(
                    "<h3>当前用户身份没有该权限！如果没有跳转，请点击<a href='" + request.getContextPath() + "/index.jsp'>超链接</a></h3>");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

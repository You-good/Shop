package com.shop.filter;

import com.shop.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("2.执行init(FilterConfig filterConfig)方法");
//        System.out.println("filter过滤器的名称"+filterConfig.getFilterName());
//        System.out.println("初始化参数username："+filterConfig.getInitParameter("username"));
//        System.out.println("初始化参数url："+filterConfig.getInitParameter("url"));
//        System.out.println("获取上下文参数："+filterConfig.getServletContext().getContextPath());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setHeader("refresh", "3;url='" + request.getContextPath() + "/login/login.jsp'");
            response.getWriter().write(
                    "<h3>会话超时 请重新登录！如果没有跳转，请点击<a href='" + request.getContextPath() + "/login/login.jsp'>超链接</a></h3>");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    @Override
    public void destroy() {
        System.out.println("filter过滤器销毁！");
    }
}

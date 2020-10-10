package com.shop.controller;

import com.google.gson.Gson;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsernameServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("用户名"+username);
        boolean exists = userService.existsUsername(username);
        System.out.println("用户名是否存在？"+exists);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        map.put("username",exists);
        Gson gson = new Gson();
        String nameJsonStr = gson.toJson(map);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(nameJsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

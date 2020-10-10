package com.shop.controller;

import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.loginUser(new User(username,password,null));
        if(loginUser==null){
            req.setAttribute("errorMsg","用户名或密码错误");
            req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
        }else{
            User user = userService.queryByUsernameAndPassword(username,password);
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //2.校验验证码是否正确 验证码写死 lcxy
        if(code.equalsIgnoreCase("lckx")){
            //3.检查用户名是否可用
            if(userService.existsUsername(username)){
                request.setAttribute("errorMsg","注册用户失败,用户名已存在");
                //用户名重复 跳回注册页面
                request.getRequestDispatcher("/login/regist.jsp").forward(request,response);
            }else{
                User user = userService.queryByUsernameAndPassword(username,password);
                request.getSession().setAttribute("user",user);
                //调用service保存到数据库
                userService.registerUser(new User(username,password,email));
                //跳转至注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("errorMsg","验证码错误");
            request.getRequestDispatcher("/login/regist.jsp").forward(request,response);
        }
    }

}

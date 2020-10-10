package com.shop.test;

import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser(){
        boolean result=userService.registerUser(new User("lxl","123","123@qq.com"));
        System.out.println(result);
    }
    @Test
    public void login(){
        User user1=userService.loginUser(new User("wyx","123",null));
        System.out.println(user1);
    }
    @Test
    public void existsUsername(){
        System.out.println();
        if(userService.existsUsername("lxl")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名不存在");
        }
    }
}

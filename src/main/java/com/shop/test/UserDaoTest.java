package com.shop.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername(){
        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }
    @Test
    public void queryUserByUsernameAndPassword(){
        if(userDao.queryUserByUsernameAndPassword("admin","123")==null){
            System.out.println("用户名密码错误");
        }else{
            System.out.println("用户名密码正确");
        }
    }
    @Test
    public void saveUser(){
        int result=userDao.saveUser(new User("wyx","123","2294106492@qq.com"));
        System.out.println(result);
    }

}

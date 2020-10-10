package com.shop.service.impl;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean registerUser(User user) {
        int result=userDao.saveUser(user);
        return (result>-1);
    }

    @Override
    public User loginUser(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return (userDao.queryUserByUsername(username)!=null);
    }

    @Override
    public User queryByUsernameAndPassword(String name, String password) {
        return userDao.queryUserByUsernameAndPassword(name, password);
    }
}

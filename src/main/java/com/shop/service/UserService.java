package com.shop.service;

import com.shop.bean.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public boolean registerUser(User user);

    /**
     * 用户登陆
     * @param user
     */
    public User loginUser(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
    public User queryByUsernameAndPassword(String name,String password);
}

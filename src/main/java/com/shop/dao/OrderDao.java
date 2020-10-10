package com.shop.dao;

import com.shop.bean.Order;

import java.util.List;

public interface OrderDao {
    public int addOrder(Order order);
    public List<Order> queryByUserId(Long userId);
    public List<Order> queryAll();
}

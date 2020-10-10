package com.shop.service;

import com.shop.bean.Order;

import java.util.List;

public interface OrderService {
    public int addOrder(Order order);
    public List<Order> queryByUserId(Long userId);
    public List<Order> queryAll();
}

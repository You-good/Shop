package com.shop.service.impl;

import com.shop.bean.Order;
import com.shop.dao.OrderDao;
import com.shop.dao.impl.OrderDaoImpl;
import com.shop.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public List<Order> queryByUserId(Long userId) {
        return orderDao.queryByUserId(userId);
    }

    @Override
    public List<Order> queryAll() {
        return orderDao.queryAll();
    }
}

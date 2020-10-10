package com.shop.service.impl;

import com.shop.bean.OrderItem;
import com.shop.dao.OrderItemDao;
import com.shop.dao.impl.OrderItemDaoImpl;
import com.shop.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public int addOrderItem(OrderItem orderItem) {
        return orderItemDao.addOrderItem(orderItem);
    }

    @Override
    public List<OrderItem> queryByOrderNum(String orderNum) {
        return orderItemDao.queryByOrderNum(orderNum);
    }
}

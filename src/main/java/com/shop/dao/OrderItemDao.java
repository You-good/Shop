package com.shop.dao;

import com.shop.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int addOrderItem(OrderItem orderItem);
    public List<OrderItem> queryByOrderNum(String orderNum);
}

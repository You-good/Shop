package com.shop.service;

import com.shop.bean.OrderItem;

import java.util.List;

public interface OrderItemService {
    public int addOrderItem(OrderItem orderItem);
    public List<OrderItem> queryByOrderNum(String orderNum);
}

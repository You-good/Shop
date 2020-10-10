package com.shop.dao.impl;

import com.shop.bean.Order;
import com.shop.dao.BaseDao;
import com.shop.dao.OrderDao;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int addOrder(Order order) {
        String sql = "INSERT INTO `order` (`userId`,`date`,`total`,`state`,`orderNum`) VALUES(?,?,?,?,?);";
        int result = update(sql,order.getUserId(),order.getDate(),order.getTotal(),order.getState(),order.getOrderNum());
        return result;
    }

    @Override
    public List<Order> queryByUserId(Long userId) {
        String sql = "SELECT * FROM `order` WHERE `userId` = ?;";
        List<Order> list = queryForList(Order.class,sql,userId);
        return list;
    }

    @Override
    public List<Order> queryAll() {
        String sql = "SELECT * FROM `order`;";
        List<Order> list = queryForList(Order.class,sql);
        return list;
    }
}

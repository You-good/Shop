package com.shop.dao.impl;

import com.shop.bean.OrderItem;
import com.shop.dao.BaseDao;
import com.shop.dao.OrderItemDao;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int addOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `orderitem` (`orderNum`,`userId`,`goodsId`,`date`,`goodsName`,`brand`,`price`,`number`,`money`) VALUES(?,?,?,?,?,?,?,?,?);";
        int result = update(sql,orderItem.getOrderNum(),orderItem.getUserId(),orderItem.getGoodsId(),orderItem.getDate(),orderItem.getGoodsName(),orderItem.getBrand(),orderItem.getPrice(),orderItem.getNumber(),orderItem.getMoney());
        return result;
    }

    @Override
    public List<OrderItem> queryByOrderNum(String orderNum) {
        String sql = "SELECT * FROM `orderitem` WHERE `orderNum` = ?";
        List<OrderItem> list = queryForList(OrderItem.class,sql,orderNum);
        return list;
    }
}

package com.shop.test;

import com.shop.bean.Order;
import com.shop.dao.OrderDao;
import com.shop.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void add(){
        Order order = new Order((long)1,new BigDecimal(32),(short)1);
        orderDao.addOrder(order);
    }
    @Test
    public void queryByUserId(){
        System.out.println(orderDao.queryByUserId((long)1));
    }

    @Test
    public void queryAll(){
        System.out.println(orderDao.queryAll());
    }
}

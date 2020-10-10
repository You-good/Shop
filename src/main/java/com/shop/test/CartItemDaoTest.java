package com.shop.test;

import com.shop.bean.CartItem;
import com.shop.bean.Goods;
import com.shop.dao.CartItemDao;
import com.shop.dao.impl.CartItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class CartItemDaoTest {
    CartItemDao cartItemDao = new CartItemDaoImpl();
    @Test
    public void addCartItem(){
        Goods goods = new Goods("电视机","海尔",new BigDecimal(3600),33,100,null);
        goods.setGoodsId((long)30);
        System.out.println(cartItemDao.addItem((long)1,goods));

    }
    @Test
    public void existsItem(){
        System.out.println(cartItemDao.existsItem((long)1,(long)30));
    }
    @Test
    public void updateItem(){
        CartItem cartItem = new CartItem((long)1,(long)3,"电视机","海尔",new BigDecimal("3600"),2,new BigDecimal("7200"));
        cartItem.setCartItemId((long)2);
        System.out.println(cartItemDao.updateItem(cartItem));
    }
    @Test
    public void queryByUser(){
        System.out.println(cartItemDao.queryByUser((long)1));
    }
    @Test
    public  void queryAll(){
        System.out.println(cartItemDao.queryByAll());
    }
}

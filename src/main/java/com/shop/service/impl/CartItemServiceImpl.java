package com.shop.service.impl;

import com.shop.bean.CartItem;
import com.shop.bean.Goods;
import com.shop.dao.CartItemDao;
import com.shop.dao.impl.CartItemDaoImpl;
import com.shop.service.CartItemService;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {
    CartItemDao cartItemDao = new CartItemDaoImpl();
    @Override
    public int addItem(Long userId, Goods goods) {
        return cartItemDao.addItem(userId, goods);
    }

    @Override
    public int deleteItems(Long userId) {
        return cartItemDao.deleteItems(userId);
    }

    @Override
    public int deleteItem(Long cartItemId) {
        return cartItemDao.deleteItem(cartItemId);
    }

    @Override
    public int updateItem(CartItem cartItem) {
        return cartItemDao.updateItem(cartItem);
    }

    @Override
    public List<CartItem> queryByUser(Long userId) {
        return cartItemDao.queryByUser(userId);
    }

    @Override
    public List<CartItem> queryByAll() {
        return cartItemDao.queryByAll();
    }

    @Override
    public CartItem existsItem(Long userId, Long goodsId) {
        return cartItemDao.existsItem(userId, goodsId);
    }
}

package com.shop.service;

import com.shop.bean.CartItem;
import com.shop.bean.Goods;

import java.util.List;

public interface CartItemService {
    public int addItem(Long userId, Goods goods);
    public int deleteItems(Long userId);
    public int deleteItem(Long cartItemId);
    public int updateItem(CartItem cartItem);
    public List<CartItem> queryByUser(Long userId);
    public List<CartItem> queryByAll();
    public CartItem existsItem(Long userId,Long goodsId);
}

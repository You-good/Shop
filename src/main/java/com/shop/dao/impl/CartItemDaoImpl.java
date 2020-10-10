package com.shop.dao.impl;

import com.shop.bean.CartItem;
import com.shop.bean.Goods;
import com.shop.dao.BaseDao;
import com.shop.dao.CartItemDao;

import java.math.BigDecimal;
import java.util.List;

public class CartItemDaoImpl extends BaseDao implements CartItemDao {
    @Override
    public int addItem(Long userId, Goods goods) {
        String sql = "INSERT INTO `cartItem` (`userId`,`goodsId`,`goodsName`,`brand`,`price`,`number`,`money`) VALUES(?,?,?,?,?,?,?);";
        int result = update(sql,userId,goods.getGoodsId(),goods.getGoodsName(),goods.getBrand(),goods.getPrice(),1,goods.getPrice());
        return result;
    }

    @Override
    public int deleteItems(Long userId) {
        String sql = "DELETE FROM `cartitem` WHERE `userId` = ?;";
        int result = update(sql,userId);
        return result;
    }

    @Override
    public int deleteItem(Long cartItemId) {
        String sql = "DELETE FROM `cartitem` WHERE `cartItemId` = ?;";
        int result = update(sql,cartItemId);
        return result;
    }

    @Override
    public int updateItem(CartItem cartItem) {
        String sql = "UPDATE `cartItem` SET `number` = ?,`money` = ? WHERE `cartItemId`=?";
        int result = update(sql,cartItem.getNumber()+1,cartItem.getPrice().multiply(new BigDecimal(cartItem.getNumber()+1)),cartItem.getCartItemId());
        return result;
    }

    @Override
    public List<CartItem> queryByUser(Long userId) {
        String sql = "SELECT * from `cartitem` WHERE `userId` = ?;";
        List<CartItem> cartItems = queryForList(CartItem.class,sql,userId);
        return cartItems;
    }

    @Override
    public List<CartItem> queryByAll() {
        String sql = "SELECT * from `cartitem`;";
        List<CartItem> cartItems = queryForList(CartItem.class,sql);
        return cartItems;
    }

    @Override
    public CartItem existsItem(Long userId, Long goodsId) {
        String sql = "SELECT * FROM `cartItem` WHERE `userId` = ? AND `goodsId` = ?;";
        CartItem cartItem = queryForOne(CartItem.class,sql,userId,goodsId);
        return cartItem;
    }
}

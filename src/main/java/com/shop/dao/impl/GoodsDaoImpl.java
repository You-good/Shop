package com.shop.dao.impl;

import com.shop.bean.Goods;
import com.shop.dao.BaseDao;
import com.shop.dao.GoodsDao;

import java.math.BigDecimal;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public int addGoods(Goods goods) {
        String sql = "INSERT INTO `goods` (`goodsName`,`brand`,`price`,`sales`,`repertory`,`picture`) VALUES(?,?,?,?,?,?);";
        int result = update(sql,goods.getGoodsName(),goods.getBrand(),goods.getPrice(),goods.getSales(),goods.getRepertory(),goods.getPicture());
        return result;
    }

    @Override
    public int deleteGoods(Long goodsId) {
        String sql = "DELETE FROM `goods` WHERE `goodsId` = ?;";
        int result = update(sql,goodsId);
        return result;
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql = "UPDATE `goods` SET `goodsName` = ?,`brand`=?,`price`=?,`sales`=?,`repertory`=?,`picture`=? WHERE `goodsId` = ?;";
        int result = update(sql,goods.getGoodsName(),goods.getBrand(),goods.getPrice(),goods.getSales(),goods.getRepertory(),goods.getPicture(),goods.getGoodsId());
        return result;
    }

    @Override
    public Goods queryById(Long goodsId) {
        String sql = "SELECT * FROM `goods` WHERE `goodsId` = ?;";
        Goods goods = queryForOne(Goods.class,sql,goodsId);
        return goods;
    }

    @Override
    public List<Goods> queryAll() {
        String sql = "SELECT * FROM `goods`;";
        List<Goods> goodsList = queryForList(Goods.class,sql);
        return goodsList;
    }

    @Override
    public List<Goods> queryByPrice(BigDecimal min, BigDecimal max) {
        String sql = "SELECT * FROM `goods` WHERE `price`>=? AND `price`<=?;";
        List<Goods> goodsList = queryForList(Goods.class,sql,min,max);
        return goodsList;
    }

    @Override
    public List<Goods> queryByPageNum(int pageNum,int pageBig) {
        String sql = "SELECT * FROM `goods` LIMIT ?,?;";
        List<Goods> goodsPage = queryForList(Goods.class,sql,(pageNum-1)*pageBig,pageBig);
        return goodsPage;
    }
}

package com.shop.service.impl;

import com.shop.bean.Goods;
import com.shop.dao.GoodsDao;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.service.GoodsService;

import java.math.BigDecimal;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int deleteGoods(Long goodsId) {
        return goodsDao.deleteGoods(goodsId);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public Goods queryById(Long goodsId) {
        return goodsDao.queryById(goodsId);
    }

    @Override
    public List<Goods> queryAll() {
        return goodsDao.queryAll();
    }

    @Override
    public List<Goods> queryByPrice(BigDecimal min, BigDecimal max) {
        return goodsDao.queryByPrice(min, max);
    }

    @Override
    public List<Goods> queryByPageNum(int pageNum,int pageBig) {
        return goodsDao.queryByPageNum(pageNum,pageBig);
    }
}

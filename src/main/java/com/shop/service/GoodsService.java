package com.shop.service;

import com.shop.bean.Goods;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsService {
    public int addGoods(Goods goods);
    public int deleteGoods(Long goodsId);
    public int updateGoods(Goods goods);
    public Goods queryById(Long goodsId);
    public List<Goods> queryAll();
    public List<Goods> queryByPrice(BigDecimal min, BigDecimal max);
    public List<Goods> queryByPageNum(int pageNum,int pageBig);
}

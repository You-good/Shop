package com.shop.test;

import com.shop.bean.Goods;
import com.shop.dao.GoodsDao;
import com.shop.dao.impl.GoodsDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class GoodsDaoTest {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Test
    public void addGoods(){
        Goods goods = new Goods("滚筒洗衣机","美的",new BigDecimal(800),36,200,null);
        int result = goodsDao.addGoods(goods);
        if (result>0){
            System.out.println("增加商品success！");
        }else{
            System.out.println("增加商品fail！");
        }
    }
    @Test
    public void deleteGoods(){
        int result = goodsDao.deleteGoods((long)3);
        if (result>0){
            System.out.println("删除商品success！");
        }else{
            System.out.println("删除商品fail！");
        }
    }
    @Test
    public void updateGoods(){
        Goods goods = new Goods("滚筒洗衣机","海尔",new BigDecimal(780),12,100,null);
        goods.setGoodsId((long)2);
        int result = goodsDao.updateGoods(goods);
        if (result>0){
            System.out.println("更新商品success！");
        }else{
            System.out.println("更新商品fail！");
        }
    }
    @Test
    public void queryById(){
        System.out.println(goodsDao.queryById((long)2));
    }
    @Test
    public void queryAll(){
        System.out.println(goodsDao.queryAll());
    }
    @Test
    public void queryByPrice(){
        System.out.println(goodsDao.queryByPrice(new BigDecimal(500),new BigDecimal(1000)).size());
    }
    @Test
    public void queryByPageNum(){
        System.out.println(goodsDao.queryByPageNum(2,5));
    }
}

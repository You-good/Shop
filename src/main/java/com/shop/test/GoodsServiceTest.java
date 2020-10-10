package com.shop.test;

import com.shop.bean.Goods;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class GoodsServiceTest {
//    GoodsDao goodsDao = new GoodsDaoImpl();
    GoodsService goodsService = new GoodsServiceImpl();
    @Test
    public void addGood(){
        Goods goods = new Goods("滚筒洗衣机","美的",new BigDecimal(800),36,200,null);
        int result = goodsService.addGoods(goods);
        if (result>0){
            System.out.println("增加商品success！");
        }else{
            System.out.println("增加商品fail！");
        }
    }
    @Test
    public void deleteGood(){
        int result = goodsService.deleteGoods((long)3);
        if (result>0){
            System.out.println("删除商品success！");
        }else{
            System.out.println("删除商品fail！");
        }
    }
    @Test
    public void updateGood(){
        Goods goods = new Goods("滚筒洗衣机","海尔",new BigDecimal(780),12,100,null);
        goods.setGoodsId((long)2);
        int result = goodsService.updateGoods(goods);
        if (result>0){
            System.out.println("更新商品success！");
        }else{
            System.out.println("更新商品fail！");
        }
    }
    @Test
    public void queryById(){
        System.out.println(goodsService.queryById((long)2));
    }
    @Test
    public void queryAll(){
        System.out.println(goodsService.queryAll());
    }
    @Test
    public void queryByPrice(){
        System.out.println(goodsService.queryByPrice(new BigDecimal(500),new BigDecimal(1000)).size());
    }
}

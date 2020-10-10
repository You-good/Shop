package com.shop.controller;

import com.shop.bean.Goods;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsDeleteServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long goodsId = Long.valueOf(req.getParameter("goodsId"));//要删除的商品ID
        System.out.println("要删除的商品ID："+goodsId);
        goodsService.deleteGoods(goodsId);
        req.getRequestDispatcher("GoodsListServlet?action=behind&pageNum=1").forward(req,resp);
    }
}

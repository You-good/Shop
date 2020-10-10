package com.shop.controller;

import com.google.gson.Gson;
import com.shop.bean.Goods;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsListServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        if ("index".equals(req.getParameter("action"))){
            System.out.println("进入首页");
            Integer pageNum = Integer.valueOf(req.getParameter("pageNum"));
            List<Goods> goodsList = goodsService.queryByPageNum(pageNum,4);
            Integer total = goodsService.queryAll().size();
            Integer endPage = (total%4==0)?total/4:(total/4+1);//最后一页
            Gson gson = new Gson();
            Object[] objects = new Object[3];
            objects[0]=goodsList;//当页商品
            objects[1]=total;//商品总数
            objects[2]=endPage;//最后一页的页数
            String goodsListJsonStr = gson.toJson(objects);
            resp.getWriter().println(goodsListJsonStr);
        }else{
            Integer pageNum = Integer.valueOf(req.getParameter("pageNum"));
            List<Goods> goodsList = goodsService.queryByPageNum(pageNum,5);
            Integer total = goodsService.queryAll().size();
            Integer  endPage = (total%5==0)?total/5:(total/5+1);//最后一页
            req.setAttribute("allNumber",total);
            req.setAttribute("goodsList",goodsList);
            req.setAttribute("pageNum",pageNum);
            req.setAttribute("endPage",endPage);
            req.getRequestDispatcher("pages/manager/shop_manager.jsp").forward(req,resp);
        }

    }
}

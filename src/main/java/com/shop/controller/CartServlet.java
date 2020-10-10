package com.shop.controller;

import com.shop.bean.CartItem;
import com.shop.bean.User;
import com.shop.service.CartItemService;
import com.shop.service.GoodsService;
import com.shop.service.OrderService;
import com.shop.service.impl.CartItemServiceImpl;
import com.shop.service.impl.GoodsServiceImpl;
import com.shop.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CartServlet extends HttpServlet {
    CartItemService cartItemService = new CartItemServiceImpl();
    GoodsService goodsService = new GoodsServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)){
            add(req, resp);
        }else if ("show".equals(action)){
            show(req, resp);
        }else if ("delItem".equals(action)){
            delItem(req, resp);
        }
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = (String) req.getParameter("userId");
        String goodsId = (String)req.getParameter("goodsId");
        String pageNum = (String)req.getParameter("pageNum");
        if (userId=="" || "".equals(userId)){
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.setHeader("refresh", "3;url='" + req.getContextPath() + "/login/login.jsp'");
            resp.getWriter().write(
                    "<h3>请先登录您的账号再加入购物车！如果没有跳转，请点击<a href='" + req.getContextPath() + "/login/login.jsp'>超链接</a></h3>");
        }else{
            CartItem cartItem = cartItemService.existsItem(Long.valueOf(userId),Long.valueOf(goodsId));
            if (cartItem==null){
                int result = cartItemService.addItem(Long.valueOf(userId),goodsService.queryById(Long.valueOf(goodsId)));
                if (result>0){
                    System.out.println("成功首次加入购物车！");
                    req.getRequestDispatcher("index.jsp?action=index&pageNum="+pageNum).forward(req,resp);
                }
            }else{
                int result = cartItemService.updateItem(cartItem);
                if (result>0){
                    System.out.println("成功再次加入购物车！");
                    req.getRequestDispatcher("index.jsp?action=index&pageNum="+pageNum).forward(req,resp);
                }
            }
        }
    }
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = ((User)req.getSession().getAttribute("user")).getUserId();
        List<CartItem> list = cartItemService.queryByUser(userId);
        BigDecimal totalMoney = new BigDecimal(0);
        for (int i=0;i<list.size();++i){
            totalMoney=totalMoney.add(list.get(i).getMoney());
        }
        req.setAttribute("totalMoney",totalMoney);
        req.setAttribute("items",list);
        req.getRequestDispatcher("pages/cart/cart.jsp").forward(req,resp);
    }
    protected void delItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cartItemId = Long.valueOf(req.getParameter("cartItemId"));
        int result = cartItemService.deleteItem(cartItemId);
        if (result>0){
            System.out.println("删除成功！");
            show(req, resp);
        }else{
            System.out.println("删除失败！");
        }
    }

}

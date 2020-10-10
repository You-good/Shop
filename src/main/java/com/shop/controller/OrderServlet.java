package com.shop.controller;

import com.shop.bean.CartItem;
import com.shop.bean.Order;
import com.shop.bean.OrderItem;
import com.shop.bean.User;
import com.shop.service.CartItemService;
import com.shop.service.OrderItemService;
import com.shop.service.OrderService;
import com.shop.service.impl.CartItemServiceImpl;
import com.shop.service.impl.OrderItemServiceImpl;
import com.shop.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class OrderServlet extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();
    OrderItemService orderItemService = new OrderItemServiceImpl();
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
        }else if ("delItems".equals(action)){
            delItems(req, resp);
        }
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = ((User)req.getSession().getAttribute("user")).getUserId();
        Order order = new Order(userId,new BigDecimal(req.getParameter("total")),(short)0);
        int result = orderService.addOrder(order);
        if (result>0){
            System.out.println("结算成功！订单已生成！");
            //生成orderItem
            List<CartItem> cartItems = cartItemService.queryByUser(userId);
            for (int i=0;i<cartItems.size();++i){
                OrderItem orderItem = new OrderItem(order.getOrderNum(),userId,cartItems.get(i).getGoodsId(),order.getDate(),cartItems.get(i).getGoodsName(),cartItems.get(i).getBrand(),cartItems.get(i).getPrice(),cartItems.get(i).getNumber(),cartItems.get(i).getMoney());
                orderItemService.addOrderItem(orderItem);
            }
            cartItemService.deleteItems(userId);//清空购物车
            req.setAttribute("orderNum",order.getOrderNum());
            req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req,resp);
        }else{
            System.out.println("结算失败！");
        }
    }
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> list = orderService.queryByUserId(((User)req.getSession().getAttribute("user")).getUserId());
        req.setAttribute("orders",list);
        req.getRequestDispatcher("pages/order/order.jsp").forward(req,resp);
    }
    protected void delItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = ((User)req.getSession().getAttribute("user")).getUserId();
        int result = cartItemService.deleteItems(userId);
        if (result>0){
            System.out.println("删除成功！");
            req.getRequestDispatcher("CartServlet?action=show").forward(req,resp);
        }else{
            System.out.println("删除失败！");
        }
    }
}

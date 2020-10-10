package com.shop.controller;

import com.shop.bean.OrderItem;
import com.shop.service.OrderItemService;
import com.shop.service.impl.OrderItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderItemServlet extends HttpServlet {
    OrderItemService orderItemService = new OrderItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderNum = req.getParameter("orderNum");
        List<OrderItem> list = orderItemService.queryByOrderNum(orderNum);
        req.setAttribute("orderItems",list);
        req.getRequestDispatcher("pages/order/orderDetail.jsp").forward(req,resp);
    }
}

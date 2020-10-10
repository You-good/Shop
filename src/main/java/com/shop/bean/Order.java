package com.shop.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private Long orderId;       //订单ID
    private Long userId;        //用户ID
    private String date;        //订单日期
    private BigDecimal total;   //订单金额
    private Short state;        //订单状态
    private String orderNum;     //订单号

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Order(Long userId, BigDecimal total, Short state) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.userId = userId;
        this.date = simpleDateFormat.format(new Date());
        this.total = total;
        this.state = state;
        this.orderNum = String.valueOf(new Date().getTime());
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", total=" + total +
                ", state=" + state +
                ", orderNum='" + orderNum + '\'' +
                '}';
    }
}

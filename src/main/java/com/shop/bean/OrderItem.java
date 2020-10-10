package com.shop.bean;

import java.math.BigDecimal;

public class OrderItem {
    private Long orderItemId;
    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    private Long userId;
    private Long goodsId;
    private String date;
    private String goodsName;
    private String brand;
    private BigDecimal price;
    private Integer number;
    private BigDecimal money;

    public OrderItem() {
    }

    public OrderItem(String orderNum,Long userId, Long proId, String date, String proName, String brand, BigDecimal price, Integer number, BigDecimal money) {
        this.orderNum = orderNum;
        this.userId = userId;
        this.goodsId = proId;
        this.date = date;
        this.goodsName = proName;
        this.brand = brand;
        this.price = price;
        this.number = number;
        this.money = money;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long proId) {
        this.goodsId = proId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String proName) {
        this.goodsName = proName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderNum='" + orderNum + '\'' +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", date='" + date + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", money=" + money +
                '}';
    }
}

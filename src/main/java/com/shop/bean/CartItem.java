package com.shop.bean;

import java.math.BigDecimal;

public class CartItem {
    private Long cartItemId;
    private Long userId;
    private Long goodsId;
    private String goodsName;
    private String brand;
    private BigDecimal price;
    private Integer number;
    private BigDecimal money;

    public CartItem() {
    }

    public CartItem(Long userId, Long proId, String proName, String brand, BigDecimal price, Integer number, BigDecimal money) {
        this.userId = userId;
        this.goodsId = proId;
        this.goodsName = proName;
        this.brand = brand;
        this.price = price;
        this.number = number;
        this.money = money;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
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
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", userId=" + userId +
                ", proId=" + goodsId +
                ", proName='" + goodsName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", money=" + money +
                '}';
    }
}

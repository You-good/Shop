package com.shop.bean;

import java.math.BigDecimal;

public class Goods {
    private Long goodsId;         //商品ID
    private String goodsName;     //名称
    private String brand;       //品牌
    private BigDecimal price;   //单价
    private Integer sales;      //销量
    private Integer repertory;  //存货
    private String picture;     //图片
    public Goods() {
    }

    public Goods(String goodsName, String brand, BigDecimal price, Integer sales, Integer repertory, String picture) {
        this.goodsName = goodsName;
        this.brand = brand;
        this.price = price;
        this.sales = sales;
        this.repertory = repertory;
        this.picture = picture;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", repertory=" + repertory +
                ", picture='" + picture + '\'' +
                '}';
    }
}

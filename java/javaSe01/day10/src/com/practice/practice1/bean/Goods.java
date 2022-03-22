package com.practice.practice1.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-21:12
 * @Since:jdk1.8
 * @Description:商品类
 */
public class Goods {
    private int id;//商品id
    private double price;//价格
    private String name;//名称
    private int num;//商品存货

    public Goods(int id, double price, String name, int num) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.num = num;
    }

    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

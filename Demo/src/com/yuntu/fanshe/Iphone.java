package com.yuntu.fanshe;
/*
* 父类
* */
public abstract class Iphone {
    private  String brand;
    private  double price;

    //自我展示信息
    public abstract void show();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

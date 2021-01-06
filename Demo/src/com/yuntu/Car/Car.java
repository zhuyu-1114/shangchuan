package com.yuntu.Car;

public abstract class Car {
    private String brand;
    private double Price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public abstract void show();
}

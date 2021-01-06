package com.yuntu.Car;

public class BYDqin extends Car {
    private String BYDqin;

    public String getBYDqin() {
        return BYDqin;
    }

    public void setBYDqin(String BYDqin) {
        this.BYDqin = BYDqin;
    }

    @Override
    public void show() {
        System.out.println("我是BYD秦，特点：经济实惠");
    }
}

package com.yuntu.Car;

public class BYDsong extends Car {
    private String BYDsong;

    public String getBYDsong() {
        return BYDsong;
    }

    public void setBYDsong(String BYDsong) {
        this.BYDsong = BYDsong;
    }

    @Override
    public void show() {
        System.out.println("我是BYDsong，特点：宋代文化");
    }
}

package com.yuntu.Car;

public class BYDhan extends Car {
    private String BYDhan;

    public String getBYDhan() {
        return BYDhan;
    }

    public void setBYDhan(String BYDhan) {
        this.BYDhan = BYDhan;
    }

    @Override
    public void show() {
        System.out.println("我是BYDhan，特点：汉代文化");
    }
}

package com.yuntu.Car;

public class BYDyuan extends Car{
    private String BYDyuan;

    public String getBYDyuan() {
        return BYDyuan;
    }

    public void setBYDyuan(String BYDyuan) {
        this.BYDyuan = BYDyuan;
    }

    @Override
    public void show() {
        System.out.println("我是BYDyuan，特点：元代文化");
    }
}

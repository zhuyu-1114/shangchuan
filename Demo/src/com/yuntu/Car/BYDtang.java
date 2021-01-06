package com.yuntu.Car;

public class BYDtang extends Car {
    private String BYDtang;

    public String getBYDtang() {
        return BYDtang;
    }

    public void setBYDtang(String BYDtang) {
        this.BYDtang = BYDtang;
    }

    @Override
    public void show() {
        System.out.println("我是BYDtang,特点：唐代文化");
    }
}

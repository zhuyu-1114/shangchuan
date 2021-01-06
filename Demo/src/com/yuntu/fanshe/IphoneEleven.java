package com.yuntu.fanshe;
/*
* 高可维护，高可拓展
* 开闭原则
* 高内聚，低耦合
*
* */
public class IphoneEleven extends Iphone{
    //自己特有的属性和功能
    private  String iphone11;

    public String getIphone11() {
        return iphone11;
    }

    public void setIphone11(String iphone11) {
        this.iphone11 = iphone11;
    }

    @Override
    public void show() {
        System.out.println("我是iphone11");
    }
}

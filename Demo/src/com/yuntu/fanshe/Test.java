package com.yuntu.fanshe;
/*
* 苹果手机
* iphone 6
* iphone 7
* iphone 7
* */
public class Test {
    public static void main(String[] args) {
        /*
        * 里式替换原则是实现多态的基础
        * 子类对象可以到父类变量中
        * */
        /*Iphone i6 = new IphoneSix();
        Iphone i7 = new IphoneSeven();
        i6.show();
        i7.show();*/
        /*Iphone iphone = Factory.createIphone("ihpone6");
        iphone.show();*/
        Iphone iphone = Factory.createIphone("com.yuntu.fanshe.IphoneEleven");
        iphone.show();
    }
}

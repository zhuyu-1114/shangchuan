package com.yuntu.fanshe;
/*
* 在程序中频繁创建对象时
* */
public class Factory {
    /*
    * 创建手机
    * @Param type 手机的类型
    * @return
    * */
    public static Iphone createIphone(String classname){
        Iphone iphone = null;
        try {
           iphone = (Iphone) Class.forName(classname).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return iphone;
       /* Iphone iphone = null;
        switch (type){
            case "ihpone6":
                iphone = new IphoneSix();
                break;
            case "ihpone7":
                iphone = new IphoneSix();
                break;
            case "ihpone8":
                iphone = new IphoneSix();
                break;
        }
        return iphone;*/
    }
}

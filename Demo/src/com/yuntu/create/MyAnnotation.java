package com.yuntu.create;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 测试自定义注解
* 之所以要去自定义注解 是因为需要在程序运行的过程中读取注解所携带的数据
* */
@Target({ElementType.TYPE,ElementType.PARAMETER,ElementType.METHOD,ElementType.CONSTRUCTOR})//表示当前定义的注解可以在类，接口 枚举类型上使用
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //至少在自定义注解中要包含一个value成员变量
    String value();
    int age();
    String name() default "张三";
}

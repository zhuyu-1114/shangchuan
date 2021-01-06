package com.yuntu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 用来实现
* */

@Target(ElementType.FIELD)//属性
@Retention(RetentionPolicy.RUNTIME)//运行期读取
public @interface DateFormatVaild {
    String value();//错误信息
    String[] format();//验证格式
}

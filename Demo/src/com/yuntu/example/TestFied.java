package com.yuntu.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/*
* 使用发射获取属性信息
* */
public class TestFied {
    public static void main(String[] args) {
        //获取Person类的class对象
        Class cls = Person.class;
        //获取Person类中公共属性对象
        Field[] fields = cls.getFields();
        for(Field f:fields){
            System.out.println("属性名称:"+f.getName());
            System.out.println("属性类型:"+f.getType());
            System.out.println("访问修饰符:"+f.getModifiers());
        }
        System.out.println("\n");
        //获取所有的字段
        Field[] fieldsAll = cls.getDeclaredFields();
        for(Field f:fieldsAll){
            System.out.println("属性名称:"+f.getName());
            System.out.println("属性类型:"+f.getType());
            System.out.println("访问修饰符:"+f.getModifiers());
            //获取属性上的注释
            java.lang.annotation.Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation a : annotations){
                System.out.println("属性的注解信息:"+a.annotationType().getTypeName());
                /*Class cls1 = a.annotationType().getClass();*/
            }
        }
    }
}

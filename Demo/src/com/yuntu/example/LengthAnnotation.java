package com.yuntu.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
*
* */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthAnnotation {
    String value();
    int max();
    int min();
}

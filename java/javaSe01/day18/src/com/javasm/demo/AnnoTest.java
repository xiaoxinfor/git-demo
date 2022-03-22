package com.javasm.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-16:04
 * @Since:jdk1.8
 * @Description:
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoTest {
    String name();
    int[] num();
    int age() default 18;
}

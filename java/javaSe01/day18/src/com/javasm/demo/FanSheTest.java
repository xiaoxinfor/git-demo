package com.javasm.demo;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-16:09
 * @Since:jdk1.8
 * @Description:
 */
public class FanSheTest {
    public static void main(String[] args) {
        try {
            //拿到类
            Class aClass = Class.forName("com.javasm.fansheBean.User");
            //反射拿到类的注解
            Annotation[] annotations = aClass.getAnnotations();
            System.out.println(Arrays.toString(annotations));
            //拿到成员变量的注解
            //先拿到属性
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

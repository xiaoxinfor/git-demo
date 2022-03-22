package com.javayx.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-14:17
 * @Since:jdk1.8
 * @Description:
 */
public class Cat extends Pet {
    /**
     * 方法重写
     */
    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }
}

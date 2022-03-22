package com.javayx.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-14:18
 * @Since:jdk1.8
 * @Description:
 */
public class Dog extends Pet {
    /**
     * 方法重载
     */
    @Override
    public void eat() {
        System.out.println("狗吃狗粮");
    }
}

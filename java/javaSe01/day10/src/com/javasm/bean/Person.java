package com.javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-11:30
 * @Since:jdk1.8
 * @Description:
 */
public class Person {
    /**
     *
     */
    public String name;//公共的都可以访问
    private int id;//私有的属性只能在同一个类中访问
    String phone;
    protected int age;
}

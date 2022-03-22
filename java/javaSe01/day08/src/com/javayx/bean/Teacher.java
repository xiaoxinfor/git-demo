package com.javayx.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-14:56
 * @Since:jdk1.8
 * @Description:抽象类
 */
public abstract class Teacher {
    private String name;
    private int age;
    /**
     * 抽象方法
     * 抽象方法必须在抽象类中，抽象类中不一定只有抽象方法
     */
    public abstract void introduce();
    public abstract String teaching();
}

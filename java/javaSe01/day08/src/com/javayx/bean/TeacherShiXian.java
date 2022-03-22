package com.javayx.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-14:59
 * @Since:jdk1.8
 * @Description:
 */
public class TeacherShiXian extends Teacher{
    /**
     * 实现抽象类中的抽象方法
     */
    @Override
    public void introduce() {
        System.out.println("在做自我介绍");
    }

    @Override
    public String teaching() {
        return "javaSe";
    }
}

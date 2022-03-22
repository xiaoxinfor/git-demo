package com.practice.practice2;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-23:15
 * @Since:jdk1.8
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());

        t1.setName("求素数之和");
        t2.setName("求素数个数");

        t1.start();
        t2.start();
    }
}

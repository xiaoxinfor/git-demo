package com.practice.practice1;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-22:37
 * @Since:jdk1.8
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new Thread(new MyRunnable());
        t2.setName("t2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
            System.out.println("睡");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

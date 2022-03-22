package com.javasm.demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-16:20
 * @Since:jdk1.8
 * @Description:
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main" + "--->" + i);
        }
    }
}

package com.javasm.demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-16:18
 * @Since:jdk1.8
 * @Description:
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
        }
    }
}

package com.practice.practice1;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-22:47
 * @Since:jdk1.8
 * @Description:
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("睡");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println("睡");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

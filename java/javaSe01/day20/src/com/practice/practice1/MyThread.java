package com.practice.practice1;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-22:35
 * @Since:jdk1.8
 * @Description:
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("睡");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName());
        try {
            Thread.sleep(1000);
            System.out.println("睡");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

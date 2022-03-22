package com.javasm.demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/8-10:58
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fdsa");
    }
}

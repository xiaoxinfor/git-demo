package com.javasm.demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-16:26
 * @Since:jdk1.8
 * @Description:
 */
public class RunnableThreadDemo {
    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        Thread t = new Thread(runnableThread);
        t.start();

        //main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main" + "---->" + i);
        }
    }
}

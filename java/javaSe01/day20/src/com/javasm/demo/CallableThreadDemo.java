package com.javasm.demo;

import java.util.concurrent.FutureTask;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-16:42
 * @Since:jdk1.8
 * @Description:
 */
public class CallableThreadDemo {
    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        FutureTask<String> futureTask = new FutureTask<>(callableThread);
        new Thread(futureTask).start();

        //main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main" + "--->" + i);
        }
    }
}

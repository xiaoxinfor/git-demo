package com.javasm.demo;

import java.util.concurrent.Callable;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-16:28
 * @Since:jdk1.8
 * @Description:
 */
public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
        return "ok";
    }
}

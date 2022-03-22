package com.practice.practice2;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-23:14
 * @Since:jdk1.8
 * @Description:求素数之和
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 2; i <= 100; i++) {
            int j = 0;
            for (j = 2; j <= i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (i == j) {
                sum += i;
            }
        }
        System.out.println(Thread.currentThread().getName() + sum);
    }
}

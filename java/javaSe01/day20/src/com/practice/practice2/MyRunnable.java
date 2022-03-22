package com.practice.practice2;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-23:14
 * @Since:jdk1.8
 * @Description:求出100-200之间素数的个数
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        int count = 0;
        for (int i = 100; i <= 200 ; i++) {
            int j = 0;
            for (j = 2; j <= i ; j++) {
                if (i%j==0){
                    break;
                }
            }
            if (i == j){
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + count);
    }
}

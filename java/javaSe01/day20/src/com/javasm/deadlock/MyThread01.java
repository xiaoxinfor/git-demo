package com.javasm.deadlock;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-21:58
 * @Since:jdk1.8
 * @Description:
 */
public class MyThread01 extends Thread{
    Object object1;
    Object object2;

    public MyThread01(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object1){
            try {
                //等一秒，加大死锁的几率
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){

            }
        }
    }
}

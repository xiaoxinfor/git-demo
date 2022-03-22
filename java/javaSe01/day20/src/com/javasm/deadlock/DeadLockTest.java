package com.javasm.deadlock;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-22:01
 * @Since:jdk1.8
 * @Description:
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        //线程对象，t1和t2两个线程共享object1,object2
        Thread t1 = new MyThread01(object1,object2);
        Thread t2 = new MyThread02(object1,object2);


        //t1锁object1的时候，t2把object2给锁了，t1得不到object2的锁，t2也一样，导致程序结束不了，也不会报错，造成死锁
        t1.start();
        t2.start();

    }

}

package com.javasm.demo;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/23-14:15
 * @Since:jdk1.8
 * @Description:
 */
public class ThreadTest {
    public static void main(String[] args) {
        //一个共享的仓库
        List list = new ArrayList();
        //创建两个线程对象
        Thread t1 = new Thread(new Product(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.setName("生产者线程");
        t2.setName("消费者线程");
        t1.start();
        t2.start();
    }
}

/**
 * 生产线程
 */
class Product implements Runnable {
    private List list;

    public Product(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产
        synchronized (list) {
            while (true) {
                if (list.size() > 0) {
                    //当前线程进入等待
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序能够执行到这里说明仓库是空的，可以生产
                Object o = new Object();
                list.add(o);
                System.out.println(Thread.currentThread().getName() + "-->" + o);
                //唤醒
                list.notifyAll();
            }
        }
    }
}

/**
 * 消费线程
 */
class Consumer implements Runnable {
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            //一直消费
            while (true) {
                if (list.size() == 0) {
                    //当前线程进入等待
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序能够执行到这里说明仓库是空的，可以生产
                Object o = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "-->" + o);
                //唤醒
                list.notifyAll();
            }
        }
    }
}

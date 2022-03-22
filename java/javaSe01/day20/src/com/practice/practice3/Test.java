package com.practice.practice3;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/23-10:09
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //创建票池对象，只能有一个
        Ticket ticket = new Ticket(1000);

        //多个用户抢票，多个线程
        for (int i = 1; i < 1001; i++) {
            Thread t = new MyThread(ticket);
            t.setName("t" + i);
            t.start();
        }
    }
}

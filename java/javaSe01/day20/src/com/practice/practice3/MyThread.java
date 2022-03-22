package com.practice.practice3;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/23-10:05
 * @Since:jdk1.8
 * @Description:
 */
public class MyThread extends Thread{
    //多个抢票线程共享一个票池
    private Ticket ticket;
    //通过构造方法传过来抢票对象
    public MyThread(Ticket ticket){
        this.ticket = ticket;
    }
    @Override
    public void run() {
        ticket.qiang((int)(Math.random()*3));

    }
}

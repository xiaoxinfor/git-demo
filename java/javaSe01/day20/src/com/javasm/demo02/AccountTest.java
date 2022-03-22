package com.javasm.demo02;

import com.javasm.bean.Account;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-20:33
 * @Since:jdk1.8
 * @Description:
 */
public class AccountTest {
    public static void main(String[] args) {
        //创建账户对象，只创建一个
        Account act = new Account("act_101",10000);
        //创建两个线程,共享同一个对象
        Thread t1 = new AccountThread(act);
        Thread t2 = new AccountThread(act);

        t1.setName("t1");
        t2.setName("t2");

        //启动线程
        t1.start();
        t2.start();
    }
}

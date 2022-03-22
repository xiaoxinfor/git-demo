package com.javasm.demo02;

import com.javasm.bean.Account;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-20:30
 * @Since:jdk1.8
 * @Description:
 */
public class AccountThread extends  Thread{
    //两个线程必须共享同一个对象
    private Account act;

    //通过构造方法传过来账户对象
    public AccountThread(Account act){
        this.act = act;
    }

    @Override
    public void run() {
        //取款5000
        act.withdraw(5000);
        System.out.println(Thread.currentThread().getName() + "取款成功，余额" + act.getBalance() );
    }
}

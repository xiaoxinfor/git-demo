package com.javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-20:24
 * @Since:jdk1.8
 * @Description:模拟取款
 */
public class Account {
    private String actno;//账号
    private double balance;//余额

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public Account() {
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取款方法
    public void withdraw(double money) {
        synchronized (this) {
            double before = this.balance;
            double after = before - money;
            //模拟网络延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新余额
            this.setBalance(after);
        }
    }
}

package com.javasm.atm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-17:32
 * @Since:jdk1.8
 * @Description:用户
 */
public class AtmUser {
    //姓名
    String name;
    //卡号
    private String idCard;
    //密码
    private int password;
    //余额
    private double balance;

    public AtmUser(String idCard, int password, double balance,String name) {
        this.idCard = idCard;
        this.password = password;
        this.balance = balance;
        this.name = name;
    }

    public AtmUser() {
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

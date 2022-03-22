package com.practice.practice2.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-22:24
 * @Since:jdk1.8
 * @Description:
 */
public class User {
    private String name;//用户名
    private int pwd;//密码

    public User(String name, int pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }
}

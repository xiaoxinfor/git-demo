package com.javasm.demo.practiceDemo.bean;

import java.io.Serializable;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-15:05
 * @Since:jdk1.8
 * @Description:
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5847970129504631825L;
    private String name;
    private String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}

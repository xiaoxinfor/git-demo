package com.practice.practice3;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/23-10:06
 * @Since:jdk1.8
 * @Description:
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

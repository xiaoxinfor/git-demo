package com.practice.service;

import com.practice.bean.User;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-19:03
 * @Since:jdk1.8
 * @Description:用户接口
 */
public interface UserService {
    //注册
    void addUser(User user, Scanner scanner);
    //登录
    void loginUser(User user, Scanner scanner);
    //修改登录密码
    void changeUser(User user, Scanner scanner);
}

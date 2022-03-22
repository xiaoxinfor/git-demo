package com.javasm.practice.practice5.service;

import com.javasm.practice.practice5.bean.User;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-10:51
 * @Since:jdk1.8
 * @Description:
 */
public interface UserService {
    /**
     * 注册用户
     * @param users
     * @param scanner
     * @return
     */
    User[] addUser(User[] users, Scanner scanner);

    /**
     * 显示用户
     * @param users
     * @param scanner
     */
    void showUser(User[] users,Scanner scanner);
}

package com.javasm.service;

import com.javasm.bean.User;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-17:03
 * @Since:jdk1.8
 * @Description:
 */
public interface UserService {
/**
 * 查看
 */
    void show(List<User> userList);

    void add(List<User> userList, Scanner scanner);

    void delete(List<User> userList, Scanner scanner);

    void update(List<User> userList, Scanner scanner);
}

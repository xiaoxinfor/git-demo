package com.javasm.service;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-19:31
 * @Since:jdk1.8
 * @Description:
 */
public interface UserService {
    /**
     * 注册用户
     */
    void reg(Scanner scanner);

    /**
     * 登录
     *
     * @param scanner
     * @return
     */
    String log(Scanner scanner);
}

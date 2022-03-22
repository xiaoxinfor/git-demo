package com.javasm.service;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-21:20
 * @Since:jdk1.8
 * @Description:
 */
public interface LogSuccessService {
    /**
     * 充值
     *
     * @param scanner
     * @param name
     */
    void charge(Scanner scanner, String name);

    /**
     * 修改登录密码
     *
     * @param scanner
     * @param name
     */
    boolean xiuGai(Scanner scanner, String name);

    /**
     * 显示图书信息
     */
    void show();

    /**
     * 借书
     *
     * @param scanner
     */
    void jieshu(Scanner scanner,String name);

    /**
     * 还书
     *
     * @param scanner
     * @param name
     */
    void huanShu(Scanner scanner, String name);
}

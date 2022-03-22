package com.javasm.action;

import com.javasm.service.Impl.UserServiceImpl;
import com.javasm.service.UserService;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-19:22
 * @Since:jdk1.8
 * @Description:
 */
public class BookManagerAction {
    private Scanner scanner;
    private UserService userService;
    private String isLogin;

    public BookManagerAction() {
        scanner = new Scanner(System.in);
        userService = new UserServiceImpl();
    }

    /**
     * 登录注册界面菜单
     */
    public void menu() {
        while (true) {
            System.out.println("***********欢迎使用图书管理系统***********");
            System.out.println("1、登录");
            System.out.println("2、注册");
            System.out.println("0、退出");
            System.out.println("***************************************");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    isLogin = userService.log(scanner);
                    isSuccess();
                    break;
                case 2:
                    userService.reg(scanner);
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    /**
     * 判断是否登录成功
     */
    public void isSuccess() {
        if (isLogin == null) {
            System.out.println("账号或密码错误，登录失败");
            return;
        }
        //登录
        System.out.println("***********欢迎使用图书管理系统***********");
        System.out.println("***********[欢迎您:" + isLogin + "]***********");
        new LogSuccessAction().menu(isLogin);
        System.out.println("**************************************");
        return;
    }
}

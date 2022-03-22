package com.javasm.action;

import com.javasm.bean.User;
import com.javasm.service.UserService;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/18-11:36
 * @Since:jdk1.8
 * @Description:
 */
public class UserAction {
    private Scanner scanner;
    private UserService userService;
    public UserAction(){
        scanner = new Scanner(System.in);
        userService = new UserService();
    }
    public void menu(){
        while (true) {
            System.out.println("请选择");
            System.out.println("1.添加用户信息");
            System.out.println("2删除用户信息");
            System.out.println("3修改用户信息");
            System.out.println("4查询所有用户");
            System.out.println("0退出");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    userService.add(scanner);
                    break;
                case 2:
                    userService.delete(scanner);
                case 3:
                    userService.update(scanner);
                    break;
                case 4:
                    userService.cha(scanner);
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

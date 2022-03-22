package com.javasm.action;

import com.javasm.bean.User;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-16:56
 * @Since:jdk1.8
 * @Description:
 */
public class UserAction {
    private Scanner scanner;
    private UserService userService;
    private List<User> userList;

    public UserAction() {
        scanner = new Scanner(System.in);
        userService = new UserServiceImpl();
        userList = new ArrayList<>(10);
        //初始化赋值
        userList.add(new User(1,"tom",23));
        userList.add(new User(2,"cat",20));
        userList.add(new User(3,"mike",33));
    }

    public void menu() {
        while (true) {
            System.out.println("用户信息系统");
            System.out.println("1.添加用户  2.删除用户  3.修改用户信息  4.查看  5.退出");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    userService.add(userList,scanner);
                    break;
                case 2:
                    userService.delete(userList,scanner);
                    break;
                case 3:
                    userService.update(userList,scanner);
                    break;
                case 4:
                    userService.show(userList);
                    break;
                case 5:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

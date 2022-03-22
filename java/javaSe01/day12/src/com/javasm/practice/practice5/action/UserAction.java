package com.javasm.practice.practice5.action;

import com.javasm.practice.practice5.bean.User;
import com.javasm.practice.practice5.service.UserService;
import com.javasm.practice.practice5.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-11:01
 * @Since:jdk1.8
 * @Description:
 */
public class UserAction {
    private User[] users;
    private Scanner scanner;
    private UserService userService;

    /**
     * 无参构造
     */
    public UserAction(){
        users = new User[2];
        scanner = new Scanner(System.in);
        userService = new UserServiceImpl();

        //两个初始化数据
        users[0] = new User("小白","123456","330700");
        users[1] = new User("小黑","447456","354789");
    }

    //菜单
    public void menu(){
        while (true){
            System.out.println("1.添加    2.显示   3. 退出");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    //接收返回的数组
                    users = userService.addUser(users,scanner);
                    break;
                case 2:
                    userService.showUser(users,scanner);
                    break;
                case 3:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

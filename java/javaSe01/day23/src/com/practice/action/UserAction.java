package com.practice.action;

import com.practice.bean.User;
import com.practice.service.Impl.UserServiceImpl;
import com.practice.service.UserService;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-20:07
 * @Since:jdk1.8
 * @Description:
 */
public class UserAction {
    private Scanner scanner;
    private UserService userService;
    private User user;
    public UserAction(){
        scanner = new Scanner(System.in);
        userService = new UserServiceImpl();

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
                    add();
                    break;
                case 2:
                    System.out.println("请输入要删除的用户ID");
                    userService.delete(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("请输入要修改信息的用户ID");
                    userService.update(scanner.nextInt());
                    break;
                case 4:
                    List<User> list =  userService.select();
                    System.out.println(list);
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    public void add(){
        System.out.println("请输入要添加的id、姓名、性别、电话、地址、时间");
        user = new User();
        user.setId(scanner.nextInt());
        user.setUName(scanner.next());
        user.setSex(scanner.next());
        user.setPhone(scanner.next());
        user.setAddress(scanner.next());
        user.setCreateTime(scanner.next());
        userService.insert(user);
    }
}

package com.javasm.demo.practiceDemo.action;

import com.javasm.demo.practiceDemo.bean.User;

import com.javasm.demo.practiceDemo.fileUtil.Util02;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-17:09
 * @Since:jdk1.8
 * @Description:
 */
public class FileAction02 {
    private static Scanner scanner = new Scanner(System.in);
    private static File file1 = new File("file\\user02.txt");

    public static void main(String[] args) {
        menu();
    }
    /**
     * 注册
     */
    public static void reg(){
        System.out.println("注册");
        System.out.println("请输入账号");
        String name = scanner.next();
        System.out.println("请输入密码");
        String pass = scanner.next();
        User user = new User(name,pass);
        Util02.write(file1,user,true);
        System.out.println("注册成功");
    }

    /**
     * 登录
     */
    public static void log(){
        System.out.println("登录");
        //获取数据源
        List<User> userList = Util02.read("file\\user02.txt");
        System.out.println("请输入账号");
        String name = scanner.next();
        System.out.println("请输入密码");
        String pass = scanner.next();
        for (User user : userList) {
            if (user.getName().equals(name) && user.getPass().equals(pass)){
                System.out.println("登录成功");
                return;
            }
        }
        System.out.println("登录失败");
    }

    public static void menu(){
        while (true){
            System.out.println("菜单");
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("3.显示");
            System.out.println("0.退出");
            switch (scanner.nextInt()){
                case 1:
                    reg();
                    break;
                case 2:
                    log();
                    break;
                case 3:
                    show();
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    /**
     * 显示
     */
    public static void show(){
        List<User> userList = Util02.read("file\\user02.txt");
        for (User user : userList) {
            System.out.println(user);
        }
    }
}

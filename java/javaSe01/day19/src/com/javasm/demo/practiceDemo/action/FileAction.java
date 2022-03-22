package com.javasm.demo.practiceDemo.action;

import com.javasm.demo.practiceDemo.bean.User;
import com.javasm.demo.practiceDemo.constants.FileConstants;
import com.javasm.demo.practiceDemo.fileUtil.Util;


import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-15:21
 * @Since:jdk1.8
 * @Description:
 */
public class FileAction {
    private static Scanner scanner = new Scanner(System.in);


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
        String message = user.getName()+user.getPass() + ";";
        Util.write(FileConstants.FILE_NAME,message,true);
        System.out.println("注册成功");
    }

    /**
     * 登录
     */
    public static void log(){
        System.out.println("登录");
        //获取数据源
        String readMessage = Util.read(FileConstants.FILE_NAME);
        if (readMessage == null){
            System.out.println("数据中没有任何用户");
            return;
        }
        System.out.println("请输入账号");
        String name = scanner.next();
        System.out.println("请输入密码");
        String pass = scanner.next();
        //分割字符串
        String[] strings = readMessage.split(";");
        for (String s : strings) {
            if (s.equals(name+pass)){
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
            System.out.println("3.退出");
            switch (scanner.nextInt()){
                case 1:
                    reg();
                    break;
                case 2:
                    log();
                    break;
                case 3:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

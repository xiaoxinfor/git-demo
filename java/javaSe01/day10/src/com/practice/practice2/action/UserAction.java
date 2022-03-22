package com.practice.practice2.action;

import com.practice.practice2.bean.User;
import com.practice.practice2.exception.UserException;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-22:27
 * @Since:jdk1.8
 * @Description:
 */
public class UserAction {
    //已经注册过的用户
    User[] users;
    Scanner scanner;
    /**
     * 已经注册过用户
     */
    public UserAction(){
        scanner = new Scanner(System.in);
        users = new User[3];//三个注册用户
        users[0] = new User("张三",1111);
        users[1] = new User("李四",2222);
        users[2] = new User("王五",3333);
    }

    /**
     * 查询注册过的用户
     */
    public void chaXun(){
        for (User user : users) {
            System.out.println("用户名:" + user.getName());

        }
    }

    /**
     * 注册
     */
    public void zhuCe()throws UserException{
        System.out.println("请输入您要注册的用户名：");
        String inputName = scanner.next();
        System.out.println("请输入密码：");
        int inputPwd = scanner.nextInt();
        for (User user : users) {
            if (inputName.equals(user.getName())){
                throw new UserException("该用户名已经被注册");
            }else {
                users =Arrays.copyOf(users,users.length + 1);
                users[users.length -1] = new User(inputName,inputPwd);
                System.out.println("注册成功");
                return;
            }
        }
    }
    public void menu(){

        while (true){
            System.out.println("1.注册新用户");
            System.out.println("2.查询以注册过的用户");
            System.out.println("3.退出");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    try {
                        zhuCe();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    chaXun();
                    break;
                case 3:
                    System.out.println("退出成功");
                    return;
            }


        }
    }

    public static void main(String[] args) {
        new UserAction().menu();
    }
}

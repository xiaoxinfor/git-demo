package com.practice.service.impl;

import com.practice.bean.User;
import com.practice.service.UserService;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-19:13
 * @Since:jdk1.8
 * @Description:实现用户接口
 */
public class UserImpl implements UserService {
    /**
     * 注册
     *
     * @param scanner
     */
    @Override
    public void addUser(User user, Scanner scanner) {
        System.out.println("《用户注册》");
        System.out.println("请设置账号：");
        String inputId = scanner.next();
        System.out.println("请设置密码");
        int inputPass = scanner.nextInt();
        //判断设置的账号和密码是否合法，都为4位数
        if (inputId.length() == 4 && inputPass >= 1000 && inputPass <= 9999) {
            user.setId(inputId);
            user.setPass(inputPass);
            System.out.println("账号注册成功，请记住您的账号和密码");
            System.out.println("账号：" + user.getId() + "\t" + "密码：" + user.getPass());
            return;
        }
        System.out.println("设置的账号或密码不合法，请重新设置。");
    }

    /**
     * 登录
     *
     * @param scanner
     */
    @Override
    public void loginUser(User user, Scanner scanner) {
        System.out.println("《用户登录》");
        //判断是否注册
        if (user == null || user.getId() == null){
            System.out.println("您还未注册，请先注册");
            user.setSuccess(1);//登录失败
            return;
        }
        System.out.println("注意：登录机会只有三次");
        //三次机会
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入账号：");
            String inputId = scanner.next();
            System.out.println("请输入密码：");
            int inputPass = scanner.nextInt();
            if (inputId.equals(user.getId()) && inputPass == user.getPass()) {
                System.out.println("登录成功！");
                user.setSuccess(2);//2表示登录成功
                return;
            }
            if (2 - i == 0) {
                System.out.println("登录机会以用光，请稍后再试。");
                return;
            }
            System.out.println("账号或密码错误，您还有" + (2 - i) + "次机会");
        }
    }

    /**
     * 修改密码,登录成功才能修改密码
     *
     * @param scanner
     */
    @Override
    public void changeUser(User user, Scanner scanner) {
        System.out.println("《修改密码》");
        //判断是否登录成功
        if (user.getSuccess() == -1) {
            System.out.println("抱歉，您还未登录，不能修改密码。");
            return;
        }
        System.out.println("请输入您要修改后密码");
        int inputPass1 = scanner.nextInt();
        System.out.println("请再次确认您新的密码");
        int inputPass2 = scanner.nextInt();
        if (inputPass1 == inputPass2) {
            user.setPass(inputPass2);
            System.out.println("密码修改成功。");
            return;
        }
        System.out.println("密码修改失败，请退出重试");
    }
}

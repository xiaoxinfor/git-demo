package com.javayx.lambdaUser.action;

import com.javayx.lambdaUser.bean.User;
import com.javayx.lambdaUser.userService.UserService;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-15:32
 * @Since:jdk1.8
 * @Description:
 */
public class UserAction {
    /**
     * 登录
     */
    public static void reg(User user1, Scanner scanner1) {
        UserService userService = (User user, Scanner scanner) -> {
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
                return true;
            }
            System.out.println("设置的账号或密码不合法，请重新设置。");
            return false;
        };
        userService.gongNeng(user1, scanner1);
    }

    /**
     * 注册
     */
    public static void log(User user1, Scanner scanner1) {
        UserService userService = (User user, Scanner scanner) -> {
            System.out.println("《用户登录》");
            //判断是否注册
            if (user == null || user.getId() == null) {
                System.out.println("您还未注册，请先注册");
                return false;
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
                    return true;
                }
                if (2 - i == 0) {
                    System.out.println("登录机会以用光，请稍后再试。");
                    return false;
                }
                System.out.println("账号或密码错误，您还有" + (2 - i) + "次机会");
            }
           return true;
        };
        user1.setSuccess(userService.gongNeng(user1, scanner1));
    }

    /**
     * 修改密码
     */
    public static void xiuGai(User user1, Scanner scanner1) {
        UserService userService = (User user, Scanner scanner) -> {
            System.out.println("《修改密码》");
            //判断是否登录成功
            if (!user1.isSuccess()) {
                System.out.println("抱歉，您还未登录，不能修改密码。");
                return false;
            }
            System.out.println("请输入您要修改后密码");
            int inputPass1 = scanner.nextInt();
            System.out.println("请再次确认您新的密码");
            int inputPass2 = scanner.nextInt();
            if (inputPass1 == inputPass2) {
                user.setPass(inputPass2);
                System.out.println("密码修改成功。");
                return false;
            }
            System.out.println("密码修改失败，请退出重试");
            return false;
        };
        userService.gongNeng(user1, scanner1);
    }
}
package com.javayx.lambdaUser.test;

import com.javayx.lambdaUser.action.UserAction;
import com.javayx.lambdaUser.bean.User;
import com.javayx.lambdaUser.userService.UserService;

import java.util.PrimitiveIterator;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-15:28
 * @Since:jdk1.8
 * @Description:
 */
public class UserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }

    public static void menu(Scanner scanner){
        User user =new User();
        System.out.println("       <<<<<<<<<<用户系统>>>>>>>>>>");
        boolean b = true;
        while (b) {
            System.out.println("1、用户注册。2、用户登录。3、修改密码。4、退出系统。");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    UserAction.reg(user,scanner);
                    break;
                case 2:
                    UserAction.log(user,scanner);
                    break;
                case 3:
                    UserAction.xiuGai(user,scanner);
                    break;
                case 4:
                    System.out.println("退出成功");
                    b = false;
                    break;
                default:
                    System.out.println("不合法操作，请重新选择。");
            }
        }
    }
}

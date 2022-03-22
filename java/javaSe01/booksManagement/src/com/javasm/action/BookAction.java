package com.javasm.action;

import com.javasm.constants.Admin;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-17:27
 * @Since:jdk1.8
 * @Description:
 */
public class BookAction {
    private Scanner scanner;

    public BookAction() {
        scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("书店管理销售系统");
            System.out.println("*************************");
            System.out.println("1.登录系统");
            System.out.println("2.退出");
            System.out.println("*************************");
            System.out.println("请选择，输入数字：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    boolean b = login();
                    if (!b){
                        return;
                    }
                    break;
                case 2:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    /**
     * 登录系统
     */
    private boolean login() {
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入账号：");
            String account = scanner.next();
            System.out.println("请输入密码：");
            int pwd = scanner.nextInt();
            //登录成功
            if (account.equals(Admin.ACCOUNT) && pwd == Admin.PWD) {
                managent();
                return true;
            }
            if (i == 2) {
                System.out.println("错误次数超过三次，账号被锁定");
                return false;
            }
            System.out.println("密码或账号错误，您还有" + (2 - i) + "次机会");
        }
        return false;
    }

    /**
     * 书店管理系统主菜单
     */
    private void managent() {
        boolean b = true;
        while (b) {
            System.out.println("书店管理销售系统");
            System.out.println("*******************************");
            System.out.println("1. 会 员 管 理");
            System.out.println("2.书 籍 管 理");
            System.out.println("3.购 物 结 算");
            System.out.println("4.积 分 兑 换 礼 品");
            System.out.println("5.注 销");
            System.out.println("*******************************");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    new MemberAction().memberMenu();
                    break;
                case 2:
                    new BookManageAction().bookMenu();
                    break;
                case 3:
                    new ShopAction().shopMenu();
                    break;
                case 4:
                    new IntegralAction().integralMenu();
                    break;
                case 5:
                    System.out.println("注销成功");
                    b = false;
                    break;
            }
        }
    }
}

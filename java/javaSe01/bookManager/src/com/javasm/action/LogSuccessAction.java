package com.javasm.action;

import com.javasm.service.Impl.LogSuccessServiceImpl;
import com.javasm.service.LogSuccessService;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-20:54
 * @Since:jdk1.8
 * @Description:
 */
public class LogSuccessAction {
    private Scanner scanner;
    private LogSuccessService lss;

    public LogSuccessAction() {
        scanner = new Scanner(System.in);
        lss = new LogSuccessServiceImpl();
    }

    /**
     * 登录成功界面
     */
    public void menu(String name) {
        while (true) {
            System.out.println("1、余额充值");
            System.out.println("2、修改登录密码");
            System.out.println("3、显示图书信息");
            System.out.println("4、借阅图书");
            System.out.println("5、归还图书");
            System.out.println("0、返回主菜单");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    lss.charge(scanner,name);
                    break;
                case 2:
                    boolean b = lss.xiuGai(scanner,name);
                    if (b){
                        return;
                    }
                    break;
                case 3:
                    lss.show();
                    break;
                case 4:
                    lss.jieshu(scanner,name);
                    break;
                case 5:
                    lss.huanShu(scanner,name);
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }

        }
    }
}

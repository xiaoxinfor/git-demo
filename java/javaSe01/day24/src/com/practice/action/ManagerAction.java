package com.practice.action;

import com.practice.bean.Emp;
import com.practice.service.EmpService;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/19-22:37
 * @Since:jdk1.8
 * @Description:
 */
public class ManagerAction {
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("***************欢迎使用打卡系统*****************");
            System.out.println("1、登录");
            System.out.println("2、注册");
            System.out.println("0、退出");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Emp emp = new EmpService().log();
                    if (emp != null) successLog(emp);
                    else System.out.println("登录失败,账号或密码错误");
                    break;
                case 2:
                    new EmpService().reg();
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    public void successLog(Emp emp) {
        while (true) {
            System.out.println("登录成功");
            System.out.println("1、上班打卡");
            System.out.println("2、修改自己的个人信息");
            System.out.println("3、显示自己的打卡记录");
            System.out.println("4、退出");
            System.out.println("请选择");
            switch (scanner.nextInt()) {
                case 1:
                    new EmpService().addRecord(emp);
                    break;
                case 2:
                    new EmpService().changeEmp(emp);
                    break;
                case 3:
                    new EmpService().show(emp);
                    break;
                case 4:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

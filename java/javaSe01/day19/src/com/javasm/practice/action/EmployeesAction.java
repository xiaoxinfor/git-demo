package com.javasm.practice.action;

import com.javasm.practice.bean.Employees;
import com.javasm.practice.constants.Constants;
import com.javasm.practice.service.EmployeesService;
import com.javasm.practice.service.impl.EmployeesServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-19:53
 * @Since:jdk1.8
 * @Description:
 */
public class EmployeesAction {
    private Scanner scanner;
    private EmployeesService employeesService;
    private File file;
    private Employees employees;


    public EmployeesAction() {
        scanner = new Scanner(System.in);
        employeesService = new EmployeesServiceImpl();
        file = new File(Constants.file);
    }

    /**
     * 菜单
     */
    public void menu() {
        while (true) {
            System.out.println("=======员工管理系统=======");
            System.out.println("1.添加员工信息");
            System.out.println("2.删除员工信息");
            System.out.println("3.显示所有员工信息");
            System.out.println("0.退出");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    reg();
                    break;
                case 2:
                    employeesService.read(Constants.file,scanner);
                    break;
                case 3:
                    employeesService.show(Constants.file);
                    break;
                case 0:
                    System.out.println("谢谢使用");
                    return;
            }
        }
    }

    /**
     * 注册
     */
    public void reg() {
        System.out.println("请输入员工编号：");
        Integer id = scanner.nextInt();
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();
        employees = new Employees(id,name, pwd);
        employeesService.write(file, employees, true);
    }

}

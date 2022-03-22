package com.practice.action;


import com.practice.bean.Student;
import com.practice.service.StudentService;
import com.practice.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-19:32
 * @Since:jdk1.8
 * @Description:
 */
public class StudentAction {
    private Scanner scanner;
    private StudentService studentService;
    private List<Student> studentList;

    public StudentAction() {
        scanner = new Scanner(System.in);
        studentService = new StudentServiceImpl();
        studentList = new ArrayList<>();
        //初始化赋值
        studentList.add(new Student("101", "小白", 18, "男", "12345645"));
        studentList.add(new Student("102", "小明", 17, "男", "12345696"));
        studentList.add(new Student("103", "小红", 19, "女", "12458456"));
    }

    /**
     * 菜单
     */
    public void menu() {
        while (true) {
            System.out.println("《《《欢迎使用学生管理系统》》》");
            System.out.println("1.添加学生");
            System.out.println("2.显示学生信息");
            System.out.println("3.统计人数");
            System.out.println("4.移除学生");
            System.out.println("0.退出系统");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    studentService.add(studentList,scanner);
                    break;
                case 2:
                    studentService.show(studentList);
                    break;
                case 3:
                    studentService.count(studentList);
                    break;
                case 4:
                    studentService.delete(studentList);
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

package com.practice.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.practice.bean.Student;
import com.practice.service.StudentService;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-19:43
 * @Since:jdk1.8
 * @Description:
 */
public class StudentServiceImpl implements StudentService {
    /**
     * 显示学生信息
     *
     * @param studentList
     */
    @Override
    public void show(List<Student> studentList) {
        System.out.println("学生管理系统>>显示学生信息");
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("学号","姓名","年龄","性别","联系方式");
        for (Student student : studentList) {
            consoleTable.addBody(student.getStuId(),student.getStuName(),student.getStuAge().toString(),student.getStuSex(),student.getStuPhoneNum());
        }
        consoleTable.print();
    }

    @Override
    public void add(List<Student> studentList, Scanner scanner) {
        System.out.println("学生管理系统>>添加学生");
        Student student = new Student();
        System.out.println("请输入要添加学生的相关信息");
        System.out.println("请输入学号：");
        String inputId = scanner.next();
        for (Student student1 : studentList) {
            if (inputId.equals(student1.getStuId())){
                System.out.println("该学号已在系统中，请重新输入");
                return;
            }
        }
        student.setStuId(inputId);
        System.out.println("请输入姓名：");
        student.setStuName(scanner.next());
        System.out.println("请输入年龄：");
        student.setStuAge(scanner.nextInt());
        System.out.println("请输入性别：");
        student.setStuSex(scanner.next());
        System.out.println("请输入联系方式：");
        student.setStuPhoneNum(scanner.next());

        studentList.add(student);
    }

    @Override
    public void count(List<Student> studentList) {
        System.out.println("学生管理系统>>统计学生人数");
        int sum = studentList.size();
        System.out.println("学生总人数：" + sum);
        int i = 0;//男人数
        for (Student student : studentList) {
            if (student.getStuSex().equals("男")){
                i++;
            }
        }
        System.out.println("男学生人数：" + i);
        System.out.println("女学生人数：" + (sum - i));

        double nan = (double)(i*100/sum);
        double nv = (double)((sum -i)*100/sum);
        System.out.println("男学生占比" + nan + "%");
        System.out.println("女学生占比" + nv + "%");
    }

    @Override
    public void delete(List<Student> studentList) {
        System.out.println("学生管理系统>>移除学生");
        boolean b = studentList.removeIf((t)->{
            if (t.getStuAge()<18){
                return true;
            }else {
                return false;
            }
        });
        System.out.println("是否成功移除小于十八岁的学生:" + b);
    }
}

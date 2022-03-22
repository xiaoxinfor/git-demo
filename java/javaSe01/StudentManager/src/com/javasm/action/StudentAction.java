package com.javasm.action;

import com.javasm.bean.Score;
import com.javasm.bean.Student;
import com.javasm.service.StudentService;
import com.javasm.service.impl.StudentServiceImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-20:09
 * @Since:jdk1.8
 * @Description://使用接口
 */
public class StudentAction {
    //多个学生,创建学生类的数组
    private Student[] students;
    private StudentService studentService ;
    private Scanner scanner;

    /**
     * 数据初始化写到构造方法里
     */
    public StudentAction() {
        students = new Student[3];//创建三个学生
        studentService = new StudentServiceImpl();
        scanner = new Scanner(System.in);
        //创建第一个学生
        //学生里面会有多科成绩
        Score[] scores1 = new Score[3];
        //填入成绩
        scores1[0] = new Score(1, "语文", 99);
        scores1[1] = new Score(2, "数学", 90);
        scores1[2] = new Score(3, "英语", 85);
        students[0] = new Student(101, "tom", "男", 14, scores1);
        //第二个学生
        Score[] scores2 = new Score[3];
        //填入成绩
        scores2[0] = new Score(4, "语文", 66);
        scores2[1] = new Score(5, "数学", 65);
        scores2[2] = new Score(6, "英语", 88);
        students[1] = new Student(102, "Mike", "男", 14, scores2);
        //第三个学生
        Score[] scores3 = new Score[3];
        //填入成绩
        scores3[0] = new Score(7, "语文", 76);
        scores3[1] = new Score(8, "数学", 95);
        scores3[2] = new Score(9, "英语", 78);
        students[2] = new Student(102, "妮蔻", "女", 14, scores3);
    }

    public void startMenu() {
        System.out.println("欢迎进入学生管理系统");
        while (true) {
            System.out.println("请选择：1、根据姓名查找对应成绩。2、根据姓名，计算及格的成绩有几门？并且计算出该学生的总分数！" +
                    "3、显示所有的学生以及成绩信息。0、退出");
            switch (scanner.nextInt()) {
                case 1:
                    getScoreByName();
                    break;
                case 2:
                    jiGeScore();
                    break;
                case 3:
                    studentService.show(students);
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    /**
     * 接收实现类getScoreByStuName的返回值，输入学生姓名，在接收到的返回值中寻找该学生的成绩
     */
    public void getScoreByName() {
        System.out.println("请输入您要查询的学生姓名");
        String inputName = scanner.next();
        //如果getScoreByStuName(inputName, students)这个方法的返回值为null，说明没找到该学生的姓名
        if (studentService.getScoreByStuName(inputName, students) == null || studentService.getScoreByStuName(inputName, students).length == 0) {
            System.out.println("抱歉，未找到该学生");
            return;
        }
        //用scores接收getScoreByStuName(inputName, students)这个方法的返回值
        Score[] scores = studentService.getScoreByStuName(inputName, students);
        System.out.println("科目\t成绩");
        for (Score score : scores) {
            System.out.println(score.getSubject() + "\t" + score.getNumber());
        }
    }
    /**
     * 学生及格的门数，并计算该学生的总分数
     */
    public void jiGeScore(){
        System.out.println("请输入姓名：");
        String inputName1 = scanner.next();
        for (Student student : students) {
            if (inputName1.equals(student.getStuName())) {//名字找的到
                studentService.countScoreJiGe(inputName1, students);
                return;
            }
        }
        System.out.println("抱歉，未找到该学生，请重新输入");
    }
}

package com.javasm.service.impl;

import com.javasm.bean.Score;
import com.javasm.bean.Student;
import com.javasm.service.StudentService;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-20:43
 * @Since:jdk1.8
 * @Description:实现接口
 */
public class StudentServiceImpl implements StudentService {
    /**
     * 根据学生的姓名，查找对应的成绩
     * @param stuName
     * @param student
     * @return
     */
    @Override
    public Score[] getScoreByStuName(String stuName, Student[] student) {
        for (Student student1 : student) {
            if (stuName.equals(student1.getStuName())){
                //创建一个新的Score数组来存放该学生的科目成绩
                Score[] scores = student1.getScores();
                return scores;
            }
        }
        return null;
    }

    /**
     * 根据某个学生的名称，计算及格的成绩有几门？并且计算出该学生的总分数！
     * @param stuName
     * @param student
     */
    @Override
    public void countScoreJiGe(String stuName, Student[] student) {
        int jiGe = 0;//记录有多少科及格
        double sum = 0;//总分
        for (Student student1 : student) {
            //如果传过来的stuName可以在student这个数组中找到，就将studend中的成绩数组赋值给新的数组
            if (stuName.equals(student1.getStuName())){
                Score[] scores = student1.getScores();
                for (Score score : scores) {
                    if (score.getNumber()>=60){//及格的科目
                        jiGe++;
                    }
                    sum += score.getNumber();
                }
            }
        }
        System.out.println("及格门数为：" + jiGe);
        System.out.println("总分为：" + sum);
    }

    @Override
    public void show(Student[] students) {
        System.out.println("学生信息");
        for (Student student : students) {
            System.out.println("学生姓名\t学生年龄");
            System.out.println(student.getStuName() + "\t" + student.getStuAge());
            //拿学生的分数
            Score[] scores = student.getScores();
            System.out.println("科目\t成绩");
            for (Score score : scores) {
                System.out.println(score.getSubject() + "\t" + score.getNumber());
            }
        }
    }
}

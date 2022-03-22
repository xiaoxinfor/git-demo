package com.javasm.service;

import com.javasm.bean.Score;
import com.javasm.bean.Student;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-20:33
 * @Since:jdk1.8
 * @Description:定义接口
 */
public interface StudentService {
    /**
     * 根据学生的姓名，查找对应的成绩
     */
    Score[] getScoreByStuName(String stuName, Student[] student);
    /**
     * 根据某个学生的名称，计算及格的成绩有几门？并且计算出该学生的总分数！
     */
    void countScoreJiGe(String stuName,Student[] student);
    /**
     * 显示所有的学生以及成绩信息
     */
    void show(Student[] students);
}

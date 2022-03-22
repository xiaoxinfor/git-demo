package com.practice.service;

import com.practice.bean.Student;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-19:43
 * @Since:jdk1.8
 * @Description:
 */
public interface StudentService {
    void show(List<Student> studentList);

    void add(List<Student> studentList, Scanner scanner);

    void count(List<Student> studentList);

    void delete(List<Student> studentList);
}

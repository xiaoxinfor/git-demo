package com.practice.practice1;

import cn.hutool.core.lang.ConsoleTable;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-21:03
 * @Since:jdk1.8
 * @Description:
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Student> studentSet = new TreeSet<>();
        for (int i = 0; i <= 20; i++) {
            Random random = new Random();
            int id = random.nextInt(39)+1;
            int d = random.nextInt(101);
            Student student = new Student(id,d);
            studentSet.add(student);
        }
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("id","成绩");
        for (Student student : studentSet) {
            consoleTable.addBody(student.getId().toString(),student.getScore().toString());
        }
        consoleTable.print();
        System.out.println("最低" +((TreeSet<Student>) studentSet).first());
        System.out.println("最高" +((TreeSet<Student>) studentSet).last());
    }
}

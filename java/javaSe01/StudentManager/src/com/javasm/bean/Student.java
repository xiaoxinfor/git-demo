package com.javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-19:59
 * @Since:jdk1.8
 * @Description:学生类
 */
public class Student {
    //学号
    private int stuId;
    //姓名
    private String stuName;
    //性别
    private String stuSex;
    //年龄
    private int stuAge;
    //多门成绩
    private Score[] scores;

    public Student(int stuId, String stuName, String stuSex, int stuAge, Score[] scores) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.scores = scores;
    }

    public Student() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Score[] getScores() {
        return scores;
    }

    public void setScores(Score[] scores) {
        this.scores = scores;
    }
}

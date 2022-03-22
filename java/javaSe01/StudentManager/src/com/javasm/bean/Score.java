package com.javasm.bean;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-19:59
 * @Since:jdk1.8
 * @Description:分数
 */
public class Score {
    //编号
    private int scoreId;
    //科目
    private String subject;
    //分数
    private double number;

    public Score(int scoreId, String subject, double number) {
        this.scoreId = scoreId;
        this.subject = subject;
        this.number = number;
    }

    public Score() {
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}

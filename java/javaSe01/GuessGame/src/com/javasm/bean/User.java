package com.javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-17:11
 * @Since:jdk1.8
 * @Description:
 */
public class User {
    //角色名称
    private String name;
    //拳对应的ID
    private int guessId;
    //得分
    private int score;

    public User(String name, int guessId, int score) {
        this.name = name;
        this.guessId = guessId;
        this.score = score;
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGuessId() {
        return guessId;
    }

    public void setGuessId(int guessId) {
        this.guessId = guessId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

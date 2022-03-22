package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/7-22:01
 * @Since:jdk1.8
 * @Description:
 */

public class User {
    private String act;
    private String pwd;

    public User() {
    }

    public User(String act, String pwd) {
        this.act = act;
        this.pwd = pwd;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

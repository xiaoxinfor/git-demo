package com.javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-15:31
 * @Since:jdk1.8
 * @Description:
 */
public class User {
    Integer id;
    String userName;
    String userPwd;

    public User(Integer id, String userName, String userPwd) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}

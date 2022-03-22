package com.practice.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-10:12
 * @Since:jdk1.8
 * @Description:实体类
 */
public class User {
    private String id;//账号
    private int pass;//密码
    private int success;//记录登录是否成功

    /**
     * 构造方法
     * @param id
     * @param pass
     */
    public User(String id, int pass,int success) {
        this.id = id;
        this.pass = pass;
        this.success = success;
    }

    public User() {
    }

    /**
     * get和set方法
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}

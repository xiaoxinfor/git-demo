package com.javasm.practice.bean;

import java.io.Serializable;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-19:50
 * @Since:jdk1.8
 * @Description:
 */
public class Employees implements Serializable {
    private static final long serialVersionUID = -1074500369050434468L;
    //编号
    private Integer id;
    //账号
    private String name;
    //密码
    private String pWd;

    public Employees(Integer id,String name, String pWd) {
        this.id = id;
        this.name = name;
        this.pWd = pWd;
    }

    public Employees() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpWd() {
        return pWd;
    }

    public void setpWd(String pWd) {
        this.pWd = pWd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pWd='" + pWd + '\'' +
                '}';
    }
}

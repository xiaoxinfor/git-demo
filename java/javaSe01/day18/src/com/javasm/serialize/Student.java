package com.javasm.serialize;

import java.io.Serializable;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-21:43
 * @Since:jdk1.8
 * @Description:
 */
public class Student implements Serializable {
    private String name;
    private Integer id;

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

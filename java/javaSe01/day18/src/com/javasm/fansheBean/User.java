package com.javasm.fansheBean;

import com.javasm.demo.AnnoTest;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-10:14
 * @Since:jdk1.8
 * @Description:
 */
@AnnoTest(name = "yy",num = 4)
public class User {
    @AnnoTest(name = "dd",num ={1,5})
    private Integer id;
    private String name;
    @AnnoTest(name = "gg",num =5)
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }
    @AnnoTest(name = "yy",num = {5,67,6})
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

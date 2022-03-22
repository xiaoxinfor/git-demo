package com.javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-19:32
 * @Since:jdk1.8
 * @Description:
 */
public class VueTb {
    Integer id;
    String userName;
    Integer age;
    String sex;

    public VueTb(Integer id, String userName, Integer age, String sex) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public VueTb() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "VueTb{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

package com.javasm.bean1;

import com.javasm.bean.Person;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-11:34
 * @Since:jdk1.8
 * @Description:
 */
public class Teacher extends Person {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "kk";//在不同包下,没有继承关系，只能访问到公共的属性

        Teacher teacher = new Teacher();
        teacher.age = 1;//在不同包下，子类会把父类的公共属性和受保护属性继承过来，这时候访问的是子类的受保护属性
    }
}

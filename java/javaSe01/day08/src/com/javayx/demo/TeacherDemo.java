package com.javayx.demo;

import com.javayx.bean.Teacher;
import com.javayx.bean.TeacherShiXian;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-15:01
 * @Since:jdk1.8
 * @Description:
 */
public class TeacherDemo {
    public static void main(String[] args) {
        /**
         * 注意：抽象类不能创建对象，但可以通过多态创建，父类型的引用指向子类型的对象
         */
        Teacher teacher = new TeacherShiXian();//多态
        teacher.introduce();
        System.out.println(teacher.teaching());
    }
}

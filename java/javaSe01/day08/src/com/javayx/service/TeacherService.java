package com.javayx.service;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-16:41
 * @Since:jdk1.8
 * @Description:
 */
public interface TeacherService {
    /**
     * 自我介绍的抽象方法
     * 接口中的方法访问修饰符可以省略
     */
    void introduce();
    /**
     * 授课的抽象方法
     */
    String teaching();

}

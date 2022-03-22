package com.javasm.start;

import com.javasm.action.StudentAction;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-20:18
 * @Since:jdk1.8
 * @Description:
 */
public class Start {
    public static void main(String[] args) {
        new StudentAction().startMenu();//使用StudentAction的无参构造器创建对象时，会自动初始化
    }

}

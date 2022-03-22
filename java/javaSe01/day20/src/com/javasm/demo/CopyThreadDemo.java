package com.javasm.demo;

import java.io.File;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-17:31
 * @Since:jdk1.8
 * @Description:
 */
public class CopyThreadDemo {
    public static void main(String[] args) {
        new CopyThread("线程1",new File("E:\\02 搭建第一个Java应用程序.mp4"),new File("E:\\02 搭建第一个Java应用程序01.mp4"),System.currentTimeMillis()).start();
        new CopyThread("线程2",new File("E:\\04 7练习.mp4"),new File("E:\\04 7练习01.mp4"),System.currentTimeMillis()).start();
    }
}

package com.javasm.demo;

import java.io.File;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/19-14:42
 * @Since:jdk1.8
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        create01();
    }

    public static void create01(){
        String filePath = "E:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javasm.demo;

import java.io.File;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-17:04
 * @Since:jdk1.8
 * @Description:
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("01.txt");
        try {
            file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

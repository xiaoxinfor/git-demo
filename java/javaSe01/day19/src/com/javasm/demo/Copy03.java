package com.javasm.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-11:48
 * @Since:jdk1.8
 * @Description:
 */
public class Copy03 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("myfile01");
            fileWriter = new FileWriter("myfile01Copy03");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = fileReader.read(chars)) != -1){
                fileWriter.write(chars,0,len);
            }
            System.out.println("复制完成");
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

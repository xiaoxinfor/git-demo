package com.javasm.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/19-22:28
 * @Since:jdk1.8
 * @Description:
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            //创建文件字符输入流
            fileReader = new FileReader("myfile01");
            //开始读
            char[] chars = new char[4];//一次读取4个字符
            int count = 0;
            while ((count = fileReader.read(chars)) != -1){
                System.out.print(new String(chars,0,count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

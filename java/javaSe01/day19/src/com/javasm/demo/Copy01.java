package com.javasm.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-10:23
 * @Since:jdk1.8
 * @Description:利用读和写完成复制文件操作
 */
public class Copy01 {
    public static void main(String[] args) {
        copy();
    }

    public static void copy() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("myfile01");
            fileOutputStream = new FileOutputStream("myfile01copy");
            //循环读
            int count = 0;
            byte[] bytes = new byte[1024];
            while ((count = fileInputStream.read(bytes)) != -1){
                //写入
                fileOutputStream.write(bytes,0,count);
            }
            //刷新流
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

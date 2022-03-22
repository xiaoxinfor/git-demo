package com.javasm.demo2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-17:37
 * @Since:jdk1.8
 * @Description:
 */
public class FileInputStreamDemo01 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        File file = new File("myfile");
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int count = 0;
            //循环读
            while ((count = fileInputStream.read(bytes)) != -1){
                System.out.println(new String(bytes,0,count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

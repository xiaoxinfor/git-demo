package com.javasm.demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.Temporal;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-19:26
 * @Since:jdk1.8
 * @Description:
 */
public class FileInputStreamDemo02 {
    public static void main(String[] args) {
        new FileInputStreamDemo02().test();
    }

    public void test(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("myfile");
            byte[] bytes = new byte[1024];
            int count = 0;
            while ((count = fileInputStream.read(bytes)) != -1){
                System.out.println(new String(bytes,0,count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

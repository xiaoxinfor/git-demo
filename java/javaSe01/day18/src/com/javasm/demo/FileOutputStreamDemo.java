package com.javasm.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/19-21:57
 * @Since:jdk1.8
 * @Description:
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //myfile文件不存在时会自动创建
            fos = new FileOutputStream("myfile");
            byte[] bytes = {97,98,99,100};
            //将byte数组全部写出
            fos.write(bytes);
            //将byte数组一部分写出
            fos.write(bytes,0,2);//写出ab
             //写完之后，一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

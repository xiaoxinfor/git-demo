package com.javasm.demo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/19-21:15
 * @Since:jdk1.8
 * @Description:
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("day18\\src\\com\\javasm\\demo\\tempFile1");
            //准备一个byte数组
            byte[] bytes = new byte[4];
            while (true){
                int count = fis.read(bytes);
                if (count == -1){
                    break;
                }
                System.out.print(new String(bytes,0,count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

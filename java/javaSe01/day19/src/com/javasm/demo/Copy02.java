package com.javasm.demo;

import java.io.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-11:14
 * @Since:jdk1.8
 * @Description:高效字节流复制
 */
public class Copy02 {
    public static void main(String[] args) {

        copy();
    }

    public static void copy() {
        long time = System.currentTimeMillis();
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream =null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\02 搭建第一个Java应用程序.mp4"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:\\02 搭建第一个Java应用程序22.mp4"));
            byte[] bytes = new byte[1024];
            int count = 0;
            while ((count = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,count);
            }
            System.out.println(System.currentTimeMillis() - time);
            //刷新流
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

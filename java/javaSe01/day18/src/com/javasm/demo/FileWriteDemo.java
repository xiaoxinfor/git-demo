package com.javasm.demo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/19-22:40
 * @Since:jdk1.8
 * @Description:
 */
public class FileWriteDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            //创建文件字符输出流对象

            fw = new FileWriter("myfile01");//这个构造方法会把原文件的内容清空
            //fw = new FileWriter("myfile01",true);//这个构造方法会在原文件的基础上追加
            char[] chars = {'我','是','谁'};
            fw.write(chars);
            fw.write("我是java工程师");
            //刷新
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

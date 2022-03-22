package com.javasm.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-21:54
 * @Since:jdk1.8
 * @Description:反序列化
 */
public class DeSerialize01 {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("stuends"));
            //开始反序列化，读
            Object obj = objectInputStream.readObject();
            //反序列回来是一个学生对象，所以会调用学生对象的toString方法
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

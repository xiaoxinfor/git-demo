package com.javasm.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-21:44
 * @Since:jdk1.8
 * @Description:序列化
 */
public class Serialize01 {
    public static void main(String[] args) {
        //创建对象
        Student student = new Student("ddd",22);
        //序列化
        ObjectOutputStream objectOutputStream = null;

        {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream("stuends"));
                //序列化对象
                objectOutputStream.writeObject(student);
                //刷新
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (objectOutputStream != null){
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

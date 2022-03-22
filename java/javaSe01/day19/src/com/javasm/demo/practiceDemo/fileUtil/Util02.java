package com.javasm.demo.practiceDemo.fileUtil;

import com.javasm.demo.practiceDemo.bean.User;
import com.javasm.demo.practiceDemo.stream.SimpleObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-17:09
 * @Since:jdk1.8
 * @Description:
 */
public class Util02 {
    /**
     * 序列化
     *
     * @param file
     * @param t
     * @param append
     * @param <T>
     */
    public static <T> void write(File file, T t, boolean append) {
        if (file.length() == 0) {
            try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file,append))) {
                obj.writeObject(t);
                obj.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try (ObjectOutputStream obj = new SimpleObjectOutputStream(new FileOutputStream(file,append))) {
                obj.writeObject(t);
                obj.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> List<T> read(String file) {
        List<T> userList = new ArrayList<>();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                //将读取到的对象放入集合
                userList.add((T) obj.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
}

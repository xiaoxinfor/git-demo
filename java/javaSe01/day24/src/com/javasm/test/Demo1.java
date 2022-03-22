package com.javasm.test;

import com.javasm.bean.User;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/19-15:04
 * @Since:jdk1.8
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("com.javasm.bean.User");
            Field[] files = c1.getDeclaredFields();
            for (Field file : files) {
                System.out.println(file.toString());
            }
            User user = (User) c1.newInstance();
            Method setId = c1.getDeclaredMethod("setId", Integer.class);
            setId.invoke(user,101);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
package com.javasm.fansheDemo;

import com.javasm.fansheBean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/20-10:15
 * @Since:jdk1.8
 * @Description:
 */
public class ClassDemo {
    public static void main(String[] args) {
//        test01();

//        test02(new User());
        test03();
    }

    /**
     * 方式一
     * 通过存储路径来得到类
     */
    public static void test01(){
        try {
            Class aClass=Class.forName("com.javasm.fansheBean.User");//User类的存储路径
            //根据拿到的类来创建对象
            User user = (User)aClass.newInstance();
            //反射成员属性，通过这个方法可以知道这个类有哪些成员属性
            Field[] fields = aClass.getDeclaredFields();
            System.out.println(Arrays.toString(fields));

            Field id = aClass.getDeclaredField("id");
            id.setAccessible(true);//暴力访问
            //直接赋值
            id.set(user,101);

            //name
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(user,"哈哈");
            //输出
            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法二
     * 已知对象
     */
    public static void test02(User user){
        //对象.getClass
        Class<? extends User> aClass = user.getClass();
        //通过反射获取set方法
        Method[] methods = aClass.getMethods();

        try {
            //user,setId()
            //根据方法名反射成员方法
            Method setId = aClass.getDeclaredMethod("setId", Integer.class);
            //赋值
            setId.invoke(user,102);

            //user.setName
            Method setName = aClass.getDeclaredMethod("setName", String.class);
            setName.invoke(user,"aa");

            System.out.println(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     * 方法三
     */
    public static void test03(){
        //这两行可以查看User这个类中有哪些构造方法
        Class<User> userClass = User.class;
        Constructor<?>[] constructors = userClass.getConstructors();
//        System.out.println(Arrays.toString(constructors));//把User类中的构造方法显示出来

        //具体的构造方法
        try {
            //反射构造器
            //无参构造
            Constructor<User> constructor = userClass.getConstructor();
            User user = constructor.newInstance();

            //有参构造
            Constructor<User> constructor1 = userClass.getConstructor(Integer.class, String.class);
            User user1 = constructor1.newInstance(103,"daa");
            System.out.println(user1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

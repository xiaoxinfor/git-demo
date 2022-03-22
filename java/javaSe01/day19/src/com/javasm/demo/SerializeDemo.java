package com.javasm.demo;

import com.javasm.demo.practiceDemo.bean.User;

import java.io.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-16:36
 * @Since:jdk1.8
 * @Description:
 */
public class SerializeDemo {
    public static void main(String[] args) {
        write();
        read();
    }

    /**
     * 序列化
     */
    public static void write(){
        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("user01.txt"))) {
            User user1 = new User("dada","123");
            User user2 = new User("djkaj","125");
            User user3 = new User("gasfa","124");
            obj.writeObject(user1);
            obj.writeObject(user2);
            obj.writeObject(user3);
            obj.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取对象
     */
    public static void read(){
        try(ObjectInputStream obj = new ObjectInputStream(new FileInputStream("user01.txt"))) {
            while (true){
                User user = (User)obj.readObject();
                System.out.println(user.getName() + " " + user.getPass());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            System.out.println("读取完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

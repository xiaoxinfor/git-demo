package com.javasm.demo;

import java.io.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-16:07
 * @Since:jdk1.8
 * @Description:
 */
public class DateStreamDemo {
    private static File file = new File("myfile");

    /**
     * 数据流写入
     */
    public static void write() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.write(1);
            dataOutputStream.writeBytes("你好");
            dataOutputStream.writeChar('哈');
            dataOutputStream.writeDouble(2.02);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据流输出
     */
    public static void read(){
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.read());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readDouble());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        read();
    }
}

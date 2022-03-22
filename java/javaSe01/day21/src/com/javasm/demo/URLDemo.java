package com.javasm.demo;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/23-15:38
 * @Since:jdk1.8
 * @Description:
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.csdn.net/");
            //流对象
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            System.out.println(url.getContent());
            System.out.println(url.getPath());
            while (true) {
                System.out.println(dataInputStream.readUTF());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

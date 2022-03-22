package com.javasm.demo.practiceDemo.fileUtil;

import java.io.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-15:08
 * @Since:jdk1.8
 * @Description:
 */
public class Util {
    /**
     * 写入
     * @param file
     * @param message
     * @param append
     */
    public static void write(File file, String message,boolean append){
        try (FileWriter fileWriter = new FileWriter(file,append)){
            fileWriter.write(message);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重载写入方法
     * @param file
     * @param message
     * @param append
     */
    public static void write(String file, String message,boolean append){
        try (FileWriter fileWriter = new FileWriter(file,append)){
            fileWriter.write(message);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取
     * @param file
     * @return
     */
    public static String read(File file){
        //先判断文件是否存在
        if (file == null){
            throw new NullPointerException("文件不能为空");
        }
        StringBuilder stringBuilder = new StringBuilder();
        try ( FileReader fileReader = new FileReader(file)){
            int len = 0;
            char[] chars = new char[1024];
            while ((len = fileReader.read(chars)) != -1){
                stringBuilder.append(chars,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 读取重载方法
     * @param file
     * @return
     */
    public static String read(String file){
        //先判断文件是否存在
        if (file == null){
            throw new NullPointerException("文件不能为空");
        }
        StringBuilder stringBuilder = new StringBuilder();
        try ( FileReader fileReader = new FileReader(file)){
            int len = 0;
            char[] chars = new char[1024];
            while ((len = fileReader.read(chars)) != -1){
                stringBuilder.append(chars,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}

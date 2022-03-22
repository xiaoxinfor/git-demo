package com.javasm.demo;

import java.io.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/22-16:54
 * @Since:jdk1.8
 * @Description:
 */
public class CopyThread extends Thread{
    //源文件
    private File fromFile;
    //目标文件
    private File toFile;
    //起始时间
    private long startTime;

    public CopyThread() {
    }

    public CopyThread(String name, File fromFile, File toFile, long startTime) {
        super(name);
        this.fromFile = fromFile;
        this.toFile = toFile;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程启动-->" + startTime);
        try (FileInputStream fileInputStream = new FileInputStream(fromFile);
             FileOutputStream fileOutputStream = new FileOutputStream(toFile)){
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            //阻塞
            Thread.sleep(2);

            long endTime = System.currentTimeMillis();

            System.out.println(Thread.currentThread().getName() + "-->" + (endTime - startTime));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

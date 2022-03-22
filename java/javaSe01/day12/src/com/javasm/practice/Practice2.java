package com.javasm.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/12-19:47
 * @Since:jdk1.8
 * @Description:
 */
public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String st = scanner.next();

        Random random = new Random();
        int[] index =new int[6];//用来存储字符串的索引
        //循环取六个随机数（可重复）
        for (int i = 0; i < 6; i++) {
            index[i] = random.nextInt(st.length());
        }
        //验证码
        String str = "";
        for (int i = 0; i < 6; i++) {
            str += st.charAt(index[i]);
        }
        System.out.println(str);
    }
}

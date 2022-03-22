package com.javasm.practice;

import javax.xml.transform.Source;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/12-20:07
 * @Since:jdk1.8
 * @Description:
 */
public class Practice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("几个随机数字或字母");
        int inputNum = scanner.nextInt();
        //a-z:97-122     A-Z:65-90
        Random random = new Random();
        String st = "";
        int b = 0;//记录产生了几个随机数
        while (true) {
            int randomNum = random.nextInt(123);
            if (randomNum >= 97 && randomNum <= 122) {
                char ch = (char) randomNum;
                st += ch;
                b++;
            } else if (randomNum >= 65 && randomNum <= 90) {
                char ch = (char) randomNum;
                st += ch;
                b++;
            } else if (randomNum >= 0 && randomNum <= 9) {
                st += randomNum;
                b++;
            }
            if (b == inputNum) {
                break;
            }
        }
        System.out.println(st);
    }


}

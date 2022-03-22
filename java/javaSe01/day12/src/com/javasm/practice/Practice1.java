package com.javasm.practice;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/12-19:22
 * @Since:jdk1.8
 * @Description:
 */
public class Practice1 {
    public static void main(String[] args) {
        caiShu();
    }

    public static void caiShu() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num = random.nextInt(100) + 1;
//        System.out.println(num);
        int ci = 0;//记录猜错的次数
        while (true){
            System.out.println("请猜数字：");
            int inputNum = scanner.nextInt();
            if (inputNum == num){
                System.out.println("恭喜您，猜对了！");
                break;
            }else if (inputNum < num){
                System.out.println("你猜的太小了");
                ci++;
            }else if (inputNum > num){
                System.out.println("你猜的太大了");
                ci++;
            }
        }
        if (ci == 0){
            System.out.println("太聪明了，一次就对了");
        }else if (ci>=6){
            System.out.println("你有点笨");
        }else if (ci <= 3){
            System.out.println("你还是比较聪明的");
        }else {
            System.out.println("一般般聪明");
        }
    }
}

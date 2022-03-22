package com.javasm.exceptionTest;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-15:44
 * @Since:jdk1.8
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("请输入一个数：");
            int num1 = scanner.nextInt();
            System.out.println("请在输入一个数");
            int num2 = scanner.nextInt();
            System.out.println("商：" + (num1/num2));
        }catch (InputMismatchException e){
            System.out.println("只能输入数字");
        }catch (Exception e){
            System.out.println("其他错误");
        }
    }
}

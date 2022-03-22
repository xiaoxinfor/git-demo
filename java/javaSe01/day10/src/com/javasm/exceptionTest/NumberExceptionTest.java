package com.javasm.exceptionTest;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-16:31
 * @Since:jdk1.8
 * @Description:
 */
public class NumberExceptionTest {
    public static void yiChang()throws NumberException{//抛出异常
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个数：");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        if (num2 == 0) {
            throw new NumberException("分母不能为0");//手动创建一个异常
        }
       System.out.println("商为" + (num1/num2));
    }

    public static void main(String[] args) {
        try {
            yiChang();
        } catch (NumberException e) {
            System.out.println(e.getMessage());

        }
    }
}

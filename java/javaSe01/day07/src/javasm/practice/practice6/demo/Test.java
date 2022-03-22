package javasm.practice.practice6.demo;

import javasm.practice.practice6.bean.Members;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-21:58
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Members members1 = new Members();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入会员号");
        int id = scanner.nextInt();
        System.out.println("请输入会员姓名");
        String name = scanner.next();
        System.out.println("请输入会员积分");
        int jiFen = scanner.nextInt();

        //调用对象方法
        members1.yanZ(id,name,jiFen);
        members1.chouJiang();
    }
}

package javasm.practice.practice5.demo;

import javasm.practice.practice5.bean.Admin;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-21:05
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //使用全参构造创建对象并初始化属性
        Admin admin =new Admin("xiaobai",1322);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        int pass = scanner.nextInt();
        if (admin.yanZheng(name,pass)){
            System.out.println("用户名和密码正确");
            //显示管理员信息
            System.out.println(admin.xinXi());
            return;
        }
        System.out.println("用户名和密码错误");
    }
}

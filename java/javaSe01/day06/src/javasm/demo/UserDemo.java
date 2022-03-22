package javasm.demo;

import javasm.bean.User;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-17:30
 * @Since:jdk1.8
 * @Description:
 */
public class UserDemo {
    public static void main(String[] args) {
        menu();
    }

    //菜单
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        //创建对象
        User user1 = new User();
        boolean b = true;
        while (b) {
            System.out.println("************欢迎进入奖客富翁抽奖系统*****************");
            System.out.println("1、注册");
            System.out.println("2、登录");
            System.out.println("3、抽奖");
            System.out.println("0、退出系统");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    user1.reg();
                    break;
                case 2:
                    user1.log();
                    break;
                case 3:
                    user1.luckly();
                    break;
                case 0:
                    System.out.println("系统退出，谢谢使用！");
                    b = false;
                    break;
            }
        }
    }
}

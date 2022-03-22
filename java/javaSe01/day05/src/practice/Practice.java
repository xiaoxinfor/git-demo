package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-17:50
 * @Since:jdk1.8
 * @Description:幸运抽奖功能
 */
public class Practice {
    static Scanner scanner = new Scanner(System.in);
    static String name;//用户名
    static int pass;//密码
    static int number;//随机卡号
    static int success = -1;//验证登录是否成功，-1登录不成功
    static boolean b = true;//控制菜单循环的开关

    public static void main(String[] args) {
        menu();
    }

    //菜单
    public static void menu() {
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
                    reg();
                    break;
                case 2:
                    log();
                    break;
                case 3:
                    luckyDraw();
                    break;
                case 0:
                    System.out.println("系统退出，谢谢使用！");
                    b = false;
                    break;
            }
        }
    }

    //注册
    public static void reg() {
        System.out.println("奖客富翁系统》》注册");
        System.out.println("请输入用户名：");
        name = scanner.next();
        System.out.println("请设置密码：");
        pass = scanner.nextInt();
        //四位数：1000-9999
        number = (int) (Math.random() * 9000 + 1000);
        System.out.println("注册成功，请记住您的相关信息");
        System.out.println("用户名\t密码\t会员卡号");
        System.out.println(name + "\t" + pass + "\t    " + number);
        System.out.println("是否继续y/n");
        String con = scanner.next();
        if (con.equals("n")) {
            System.out.println("系统退出，谢谢使用！");
            b = false;
        }
    }

    //登录
    public static void log() {
        System.out.println("奖客富翁系统》》登录");
        if (name == null || pass == 0) {
            System.out.println("请先注册！");
            return;
        } else {
            for (int i = 0; i < 3; i++) {//登录次数
                System.out.println("请输入用户名：");
                String inputName = scanner.next();
                System.out.println("请输入密码：");
                int inputPass = scanner.nextInt();
                if (inputName.equals(name) && inputPass == pass) {
                    System.out.println("登录成功，欢迎您：" + name);
                    success = 1;//登录成功
                    break;
                } else {
                    if (3 - i - 1 == 0) {
                        System.out.println("输入错误次数超过三次，系统自动退出登录");
                    } else {
                        System.out.println("账号或密码错误，您还有" + (3 - i - 1) + "次机会");
                    }
                    success = -1;//登录失败
                }
            }
            System.out.println("是否继续y/n");
            String con = scanner.next();
            if (con.equals("n")) {
                System.out.println("系统退出，谢谢使用！");
                b = false;
            }
        }

    }

    //抽奖
    public static void luckyDraw() {
        System.out.println("奖客富翁系统》》抽奖");
        //验证是否登录success
        if (success == -1) {
            System.out.println("未登录账号，请先登录！");
            return;
        } else {
            System.out.println("请先输入您的会员卡号：");
            int inputNum = scanner.nextInt();
            //五个幸运数字
            if (inputNum != number) {
                System.out.println("卡号输入错误，不能抽奖！");
                return;
            }
            int[] luckyNum = new int[5];
            //给幸运数字数组里面赋值随机数
            for (int i = 0; i < luckyNum.length; i++) {
                luckyNum[i] = (int) (Math.random() * 9000 + 1000);
            }
            System.out.println("本日幸运数字为" + Arrays.toString(luckyNum));
            int yes = -1;//记录是否是幸运会员
            for (int i = 0; i < luckyNum.length; i++) {
                if (inputNum == luckyNum[i]) {
                    System.out.println("恭喜您，成为本日幸运会员");
                    yes = 1;//
                }
            }
            if (yes == -1) {
                System.out.println("抱歉，您不是本日幸运会员。");
            }
            System.out.println("是否继续y/n");
            String con = scanner.next();
            if (con.equals("n")) {
                System.out.println("系统退出，谢谢使用！");
                b = false;
            }
        }
    }
}

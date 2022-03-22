package javasm.bean;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-17:22
 * @Since:jdk1.8
 * @Description:
 */
public class User {
    //账号
    public String name;
    //密码
    public int pass;
    //卡号
    public int number;
    //登录状态：1、以登录   2、未登录
    public int success;

    /**
     * 无参构造
     */
    public User() {

    }

    /**
     * 全参构造
     */
    public User(String name, int pass, int number, int success) {
        this.name = name;
        this.pass = pass;
        this.number = number;
        this.success = success;
    }

    /**
     * 注册
     */
    public void reg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("奖客富翁系统》》注册");
        System.out.println("请输入用户名：");
        this.name = scanner.next();
        System.out.println("请设置密码：");
        this.pass = scanner.nextInt();
        this.number = (int) (Math.random() * 9000 + 1000);
        System.out.println("注册成功，请记住您的相关信息");
        System.out.println("用户名\t密码\t会员卡号");
        System.out.println(this.name + "\t" + this.pass + "\t    " + this.number);
    }

    /**
     * 登录
     */
    public void log() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("奖客富翁系统》》登录");
        if (this.name == null || this.pass == 0) {
            System.out.println("请先注册！");
            return;
        }
        for (int i = 0; i < 3; i++) {//登录次数
            System.out.println("请输入用户名：");
            String inputName = scanner.next();
            System.out.println("请输入密码：");
            int inputPass = scanner.nextInt();
            if (inputName.equals(this.name) && inputPass == this.pass) {
                System.out.println("登录成功，欢迎您：" + this.name);
                this.success = 1;//登录成功
                break;
            } else {
                if (3 - i - 1 == 0) {
                    System.out.println("输入错误次数超过三次，系统自动退出登录");
                } else {
                    System.out.println("账号或密码错误，您还有" + (3 - i - 1) + "次机会");
                }
                this.success = 2;//登录失败
            }
        }
    }

    /**
     * 抽奖
     */
    public void luckly() {
        System.out.println("奖客富翁系统》》抽奖");
        //验证是否登录success,只要不等于1就是登录失败
        if (this.success != 1) {
            System.out.println("未登录账号，请先登录！");
            return;
        }
        int[] luckyNum = new int[5];
        //给幸运数字数组里面赋值随机数
        for (int i = 0; i < luckyNum.length; i++) {
            luckyNum[i] = (int) (Math.random() * 9000 + 1000);
        }
        System.out.println("本日幸运数字为" + Arrays.toString(luckyNum));
        for (int i = 0; i < luckyNum.length; i++) {
            if (this.number == luckyNum[i]) {
                System.out.println("恭喜您，成为本日幸运会员");
                return;
            }
        }
        System.out.println("抱歉，您不是本日幸运会员。");

    }
}
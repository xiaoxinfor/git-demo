package work.practice1;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-20:21
 * @Since:jdk1.8
 * @Description:
 */
public class Practice05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        System.out.println("请输入几号：");
        int day = scanner.nextInt();

        month--;//不累加本月份
        //总天数
        int sumDay = day;
        switch (month) {
            case 11:
                sumDay += 30;
            case 10:
                sumDay += 31;
            case 9:
                sumDay += 30;
            case 8:
                sumDay += 31;
            case 7:
                sumDay += 31;
            case 6:
                sumDay += 30;
            case 5:
                sumDay += 31;
            case 4:
                sumDay += 30;
            case 3:
                sumDay += 31;
            case 2:
                sumDay += 28;
            case 1:
                sumDay += 31;
                break;

        }
        System.out.println("总天数：" + sumDay);

        if (sumDay > 3) {
            int week = (sumDay - 3) % 7;
            switch (week) {
                case 0:
                    System.out.println("星期天");
                    break;
                default:
                    System.out.println("星期" + week);
                    break;
            }
        }

    }
}

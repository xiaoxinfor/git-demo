package work.practice1;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-19:27
 * @Since:jdk1.8
 * @Description:录入会员信息
 */
public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入会员号：");
        int id = scanner.nextInt();
        String k = scanner.nextLine();//扫描一个回车
        System.out.println("请录入会员生日：");
        String birthday = scanner.nextLine();
        System.out.println("请录入会员积分：");
        int jiFen = scanner.nextInt();

        if (id >= 1000 && id <= 9999 ) {
            System.out.println("录入成功");
            System.out.println("会员号为" + id);
            System.out.println("会员生日为" + birthday);
            System.out.println("会员积分为" + jiFen);
        } else {
            System.out.println("数据不合法，录入失败！");
        }
    }
}

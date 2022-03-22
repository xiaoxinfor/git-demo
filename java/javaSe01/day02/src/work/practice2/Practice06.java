package work.practice2;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-21:58
 * @Since:jdk1.8
 * @Description:ATM机的取款过程
 */
public class Practice06 {
    public static void main(String[] args) {
        final int passWord = 111111;
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while (i <= 3) {
            System.out.println("请输入密码：");
            int inputPass = scanner.nextInt();
            if (inputPass == passWord) {
                System.out.println("请输入取款金额：");
                int amount = scanner.nextInt();
                while (amount % 100 != 0 || amount < 100 || amount > 1000) {
                    System.out.println("请输入正确的金额");
                    amount = scanner.nextInt();
                }
                if (amount % 100 == 0 && amount >= 100 && amount <= 1000) {
                    System.out.println("您取了" + amount + "元");
                    System.out.println("交易完成，请取卡");
                    break;
                }
            } else {
                System.out.println("密码错误！您还有" + (3 - i) + "次机会");
                if ((3 - i) == 0) {
                    System.out.println("密码错误，请取卡");
                }
            }
            i++;
        }
    }
}

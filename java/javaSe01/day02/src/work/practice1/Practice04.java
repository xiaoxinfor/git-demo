package work.practice1;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-20:13
 * @Since:jdk1.8
 * @Description:
 */
public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个数a和b：");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a % b == 0 || a + b > 1000) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
        //三元运算符
        int result = (a % b == 0 || a + b > 1000) ? a : b;
        System.out.println(result);
    }
}

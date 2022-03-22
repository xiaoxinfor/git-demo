package work.practice1;


import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-19:57
 * @Since:jdk1.8
 * @Description:
 */
public class Practice03 {
    public static void main(String[] args) {
        //会员折扣
        Scanner scanner = new Scanner(System.in);
        System.out.println("您的会员积分是：");
        int jiFen = scanner.nextInt();

        if (jiFen > 0) {
            if (jiFen < 2000) {
                System.out.println("可享受9折优惠");
            } else if (jiFen < 4000) {
                System.out.println("可享受8折优惠");
            } else if (jiFen < 8000) {
                System.out.println("可享受7折优惠");
            } else {
                System.out.println("可享受6折优惠");
            }
        } else {
            System.out.println("积分不足");
        }
    }
}

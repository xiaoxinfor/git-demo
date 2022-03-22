package work.practice1;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-19:43
 * @Since:jdk1.8
 * @Description:抽奖规则
 */
public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入会员号：");
        int id = scanner.nextInt();

        if (id >= 1000 && id <= 9999) {
            int random = (int) (Math.random() * 10);
            int baiWei = id / 100 % 10;
            if (baiWei == random){
                System.out.println("恭喜抽到幸运会员");
            }else{
                System.out.println("谢谢惠顾");
            }
        } else {
            System.out.println("请正确输入4位数的会员号！");
        }
    }
}

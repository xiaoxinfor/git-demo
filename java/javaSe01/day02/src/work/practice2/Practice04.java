package work.practice2;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-21:18
 * @Since:jdk1.8
 * @Description:要求用户输入一个0到2之间的整数
 */
public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String answer;
        do {
            System.out.println("请输入0到2之间的整数：");
            int input = scanner.nextInt();
//            if (input == 0) {
//                System.out.println("你出的是石头");
//            } else if (input == 1) {
//                System.out.println("你出的是剪刀");
//            } else if (input == 2) {
//                System.out.println("你出的是布");
//            } else {
//                System.out.println("请输入正确的数字");
//            }

            switch (input) {
                case 0:
                    System.out.println("你出的是石头");
                    break;
                case 1:
                    System.out.println("你出的是剪刀");
                    break;
                case 2:
                    System.out.println("你出的是布");
                    break;
                default:
                    System.out.println("请输入正确的数字");
            }

            System.out.println("还要继续出拳吗？（y/n）");
            answer = scanner.next();

            if (answer.equals("n")) {
                System.out.println("游戏结束");
                break;
            }
        } while (answer.equals("y"));


    }
}

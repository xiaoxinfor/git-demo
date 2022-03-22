package practice;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-19:15
 * @Since:jdk1.8
 * @Description:点外卖
 */
public class practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menu = {"辣椒炒肉", "鱼香肉丝", "烤肉饭", "红烧肉", "紫菜蛋汤"};
        int[] price = {10, 11, 12, 15, 5};
        //主菜单
        System.out.println("********菜单********");
        System.out.println("菜品\t价格");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i] + "；" + price[i]);
        }
        int sumPrice = 0;//记录点餐的总价格
        while (true) {
            System.out.println("请点餐：");
            //输入菜名
            String inputEat = scanner.next();
            int caiIndex = -1;//用来接收点的菜的下标

            for (int i = 0; i < menu.length; i++) {
                //若菜单中存在输入的菜名，就记录下该菜名的下标
                if (inputEat.equals(menu[i])) {
                    caiIndex = i;
                }
            }
            if (caiIndex == -1) {
                System.out.println("抱歉，系统中未找到此菜名，请重新点餐");
            } else {
                //通过菜名的下标找到该菜品的价格为price[caiIndex]
                System.out.println("您点了" + inputEat + "其价格为：" + price[caiIndex]);
                sumPrice += price[caiIndex];
                System.out.println("还要继续点餐吗？（y/n）");
                String answer = scanner.next();
                if (answer.equals("n")) {
                    System.out.println("点餐结束，您一共消费了" + sumPrice + "元。");
                    break;
                }
            }
        }
    }
}

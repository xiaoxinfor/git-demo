package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-10:01
 * @Since:jdk1.8
 * @Description:点餐修改版
 */
public class NewPractice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menu = {"辣椒炒肉", "鱼香肉丝", "烤肉饭", "红烧肉", "紫菜蛋汤"};
        int[] price = {10, 11, 12, 15, 5};
        int[] car = new int[0];//购物车

        boolean control = true;//控制点餐系统循环的退出
        while (control) {
            System.out.println("********欢迎进入点餐系统*********");
            System.out.println("1、显示菜单信息");
            System.out.println("2、点餐");
            System.out.println("3、结算");
            System.out.println("4、退出系统");

            System.out.println("请选择：");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("********菜单********");
                    System.out.println("菜品\t价格");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println(menu[i] + "；" + price[i]);
                    }
                    break;
                case 2:
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
                            //加入购物车，扩容
                            car= Arrays.copyOf(car, car.length + 1);
                            car[car.length - 1] = caiIndex;
                            }
                        System.out.println("还要继续点餐吗？（y/n）");
                        String answer = scanner.next();
                        if (answer.equals("n")) {
                            System.out.println("点餐结束，请进入结算页面结算");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("购物车");
                    System.out.println("菜名\t价格");
                    int sumPrice = 0;//记录总价格
                    for (int i = 0; i < car.length; i++) {
                        System.out.println(menu[car[i]] + "\t" + price[car[i]]);
                        sumPrice += price[car[i]];
                    }
                    System.out.println("您需支付" + sumPrice + "元");
                    break;
                case 4:
                    System.out.println("点餐结束，谢谢使用");
                    control = false;
                    break;
            }
        }
    }
}

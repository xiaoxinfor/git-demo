package work.practice2;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-20:36
 * @Since:jdk1.8
 * @Description:循环录入Java考试的成绩
 */
public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入班级人数：");
        int numPeople = scanner.nextInt();
        int i = 1;
        double sum80 = 0,sum60 = 0;//sum为分数大于80以及小于60分的人数累加
        while (i <= numPeople) {
            System.out.println("请输入第" + i + "位考生的考试成绩：");
            double score = scanner.nextDouble();
            if (score > 80 ) {
                sum80++;
            }else if (score < 60){
                sum60++;
            }
            i++;
        }
        double biLi80 = sum80/numPeople;
        double biLi60 = sum60/numPeople;
        System.out.println("分数大于80所占的比例为" + biLi80*100 + "%");
        System.out.println("分数小于60所占的比例为" + biLi60*100 + "%");
    }
}

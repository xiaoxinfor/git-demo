package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/1-11:51
 * @Since:jdk1.8
 * @Description:
 */
public class Practice03 {
    public static void main(String[] args) {
        double[] arr = new double[10];
        Scanner scanner = new Scanner(System.in);

        //评委打分
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "位评委打分：");
            double score = scanner.nextDouble();
            arr[i] = score;
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }
        System.out.println("各评委打分分数：");
        System.out.println(Arrays.toString(arr));

        double max = arr[0];
        double min = arr[0];
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
            min = arr[i] <min ? arr[i] : min;
            sum += arr[i];//总分
        }
        double avg = (sum - max - min)/(arr.length - 2);
        System.out.println("平均分为：" + avg);
    }
}

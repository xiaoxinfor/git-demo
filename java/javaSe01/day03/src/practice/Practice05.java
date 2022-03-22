package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/1-14:01
 * @Since:jdk1.8
 * @Description:
 */
public class Practice05 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入数字");
            int inputNum = scanner.nextInt();
            arr[i] = inputNum;
            for (int j = 0; j < i; j++) {
                if (inputNum == arr[j]) {
                    System.out.println("出现了重复的数字");
                    i--;
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}

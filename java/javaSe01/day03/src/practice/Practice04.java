package practice;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/1-13:21
 * @Since:jdk1.8
 * @Description:
 */
public class Practice04 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, 5, -2};
        //将小于0的元素改为0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }


        //逆序
        /*1 数组翻转方式：
        翻转次数arr.length/2;
        将arr[0]和arr[4]调换位置
        arr[1]和arr[3]交换
         */

        int temp = 0;//中转站
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        System.out.println("翻转后的数组：");
        System.out.println(Arrays.toString(arr));

        //逆序方式
        int[] newArr = new int[arr.length];//创建一个大小相同的新数组

        for (int i = arr.length - 1,j = 0; i >= 0; i--,j++) {
            //第一轮将arr的最后一个位置的数放置在newArr的第一位上，接下来几次循环以此类推
            newArr[j] = arr[i];
        }
        System.out.println("\n" + "逆序后的数组：");
        System.out.println(Arrays.toString(newArr));
    }
}

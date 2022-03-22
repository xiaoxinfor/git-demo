import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-16:29
 * @Since:jdk1.8
 * @Description:冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
         /*
        要经过arr.length - 1轮排序、可以看做成外层循环arr.length - 1次
        每一轮排序可以确定一个数的位置
        比如第一轮排序可以将最大数排到最后
        */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //将相邻的两个数比较，如果前面的数大于后面的数，就将他们交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

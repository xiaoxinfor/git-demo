import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-17:52
 * @Since:jdk1.8
 * @Description:选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};

        for (int i = 0; i < arr.length - 1; i++) {//外层循环
            int min = arr[i];//所认为的最小值
            int indexMin = i;//最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    indexMin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

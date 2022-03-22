import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-11:26
 * @Since:jdk1.8
 * @Description:二维数组
 */
public class ArrayDemo01 {
    public static void main(String[] args) {
        //动态初始化
        int[][] arr1 = new int[3][3];
        arr1[0][0] = 1;
        arr1[0][1] = 2;
        arr1[1][0] = 3;
        arr1[1][1] = 4;
        arr1[1][2] = 5;
        arr1[2][0] = 6;
        arr1[2][1] = 7;
        System.out.println(Arrays.deepToString(arr1));

        //静态初始化
        int[][] arr2 = {{9,87},{8,12,1},{0,3,6,98}};
        //增强for
        for (int[] a : arr2) {
            System.out.println(Arrays.toString(a));
        }
    }
}

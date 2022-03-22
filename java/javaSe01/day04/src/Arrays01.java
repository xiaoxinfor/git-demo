import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-11:49
 * @Since:jdk1.8
 * @Description:
 */
public class Arrays01 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        System.out.println(arr1 == arr2);//数组是引用数据类型，用等于号比较的是内存地址
        //用Arrays.equals比较的是数组中的值
        System.out.println(Arrays.equals(arr1, arr2));
    }
}

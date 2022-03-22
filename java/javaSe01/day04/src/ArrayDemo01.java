/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-11:39
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        //增强for循环可以不通过下标快速取出数组中的值
        for (int i : arr) {
            System.out.println(i);
        }

    }
}

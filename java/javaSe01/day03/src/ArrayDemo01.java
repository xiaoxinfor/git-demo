/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-16:39
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        for (int i = 0; i < 10; i++) {
            array1[i] = i+1;
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.println("第" + (i + 1) + "个数组" + array1[i]);
        }
    }
}

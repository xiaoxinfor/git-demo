package practice;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-19:25
 * @Since:jdk1.8
 * @Description:
 */
public class Practice02 {
    public static void main(String[] args) {
        int[] oldArr = {1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        int ge = 0;//计算非0的个数
        //循环遍历数组中的元素
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] != 0){
                ge++;
            }
        }
        System.out.println("非0的个数为" +ge);
        //定义一个没有0的新数组
        int[] newArr = new int[ge];
        int index = 0;//新数组的下标

        for (int i = 0; i < oldArr.length; i++) {
            //将非0的数存入新数组
            if (oldArr[i] != 0 ){
                newArr[index] = oldArr[i];
                index++;
            }
        }
        System.out.println("新数组中的元素：");
        System.out.println(Arrays.toString(newArr));
    }
}

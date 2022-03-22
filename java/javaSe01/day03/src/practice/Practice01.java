package practice;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-19:06
 * @Since:jdk1.8
 * @Description:定义一个数组，录入一组数字
 */
public class Practice01 {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个数字：");
        int inputNum = scanner.nextInt();
        //将数据填入数组
        int ge = 0;//出现的次数
        for (int i = 0; i < 10; i++) {
            array1[i] = (int)(Math.random()*10);
            if (inputNum == array1[i]){
                ge++;
            }
        }
        //输出
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "个元素为" + array1[i]);
        }
        if (ge > 0) {
            System.out.println(inputNum + "出现过" + ge + "次");
        }else{
            System.out.println(inputNum + "没有出现过");
        }
    }
}

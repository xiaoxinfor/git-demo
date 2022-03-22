import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/29-17:52
 * @Since:jdk1.8
 * @Description:三元运算符
 */
public class Demo04 {
    public static void main(String[] args) {
        //比大小、取最大值
        Scanner input = new Scanner(System.in);
        System.out.println("请输入a的值：");
        int a = input.nextInt();
        System.out.println("请输入b的值：");
        int b = input.nextInt();
//        int a = 10, b = 20;
        int c = a > b ? a : b;
        System.out.println(c);

        //判断是不是偶数
        int d = 20;
        String result = d % 2 == 0 ? "是偶数" : "是奇数";
        System.out.println(result);
    }
}

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-11:34
 * @Since:jdk1.8
 * @Description:
 */
public class ForDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int inputNum = scanner.nextInt();

        boolean b = true;//假设这个数是素数

        for (int i = 2; i < inputNum; i++) {
            if (inputNum % i == 0) {
                System.out.println("不是素数");
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("是素数");
        }
    }
}

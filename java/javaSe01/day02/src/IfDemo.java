import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-11:29
 * @Since:jdk1.8
 * @Description:
 */
public class IfDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        if (year >= 1900) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + "是世纪闰年");
                } else {
                    System.out.println(year + "是普通闰年");
                }
            } else {
                System.out.println(year + "不是闰年");
            }
        }else {
            System.out.println("无效输入，请输入正确年份");
        }
    }
}

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-11:03
 * @Since:jdk1.8
 * @Description:Scanner
 */
public class ScannerDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        String s = scanner.nextLine();//扫描一个回车
        System.out.println("请输入电话号码：");
        String phoneNum = scanner.nextLine();
        System.out.println("请输入身高：");
        double hight = scanner.nextDouble();

        System.out.println("个人基本信息");
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("电话号码：" + phoneNum);
        System.out.println("身高：" + hight);
    }
}

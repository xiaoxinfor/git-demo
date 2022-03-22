import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-15:15
 * @Since:jdk1.8
 * @Description:
 */
public class SwitchDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个符号");
        String fuHao = scanner.next();
        System.out.println("请输入两个数：");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = 0;
        switch (fuHao){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "%":
                result = a % b;
                break;
            default:
                System.out.println("请输入正确的符号");
        }
        System.out.println("计算结果：" + a + fuHao + b + "=" + result);
    }
}

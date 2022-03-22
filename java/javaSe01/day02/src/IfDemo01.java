import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-12:56
 * @Since:jdk1.8
 * @Description:if验证三角形是否合法
 */
public class IfDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入a边长：");
        int a = scanner.nextInt();
        System.out.println("请输入b边长：");
        int b = scanner.nextInt();
        System.out.println("请输入c边长：");
        int c = scanner.nextInt();

        //只要三条边中有任意一条小于0：不合法！
        if (a < 0 || b < 0 || c < 0){
            System.out.println("三角形的边不能小于0");
        }else{
            if (a + b > c && a + c > b && b + c > a){
                System.out.println("合法三角形");
            }else{
                System.out.println("三角形不合法");
            }
        }
    }
}

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-13:07
 * @Since:jdk1.8
 * @Description:练习
 */
public class Practice {
    public static void main(String[] args) {
        final int account = 110110;
        final int passWord = 123456;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号：");
        int inputAct = scanner.nextInt();
        System.out.println("请输入密码：");
        int inputPass = scanner.nextInt();

        //验证登录
        if (inputAct == account && inputPass == passWord){
            System.out.println("账号密码正确，登录成功");
        }else {
            System.out.println("账号或密码错误，请重新输入");
        }
    }
}

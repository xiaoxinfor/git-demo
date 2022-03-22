import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-16:51
 * @Since:jdk1.8
 * @Description:
 */
public class WhileDemo02 {
    public static void main(String[] args) {
        //闰年
        int year = 2000;
        while (year <= 2021){
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                System.out.println(year + "是闰年");
            }
            year++;
        }

        System.out.println("--------------------------------------------");

        //水仙花数:1^3 + 5^3+ 3^3 = 153
        int shu = 100;
        while (shu <= 999){
            if ((shu/100)*(shu/100)*(shu/100) + (shu/10%10)*(shu/10%10)*(shu/10%10) + (shu%10)*(shu%10)*(shu%10) == shu){
                System.out.println(shu + "是水仙花数");
            }
            shu++;
        }

        System.out.println("----------------------------------------------");

        //判断用户登录次数
        final int account = 110110;
        final int passWord = 123456;

        Scanner scanner = new Scanner(System.in);

        int num = 1;
        while (num <= 3){
            System.out.println("请输入账号：");
            int inputAct = scanner.nextInt();
            System.out.println("请输入密码：");
            int inputPass = scanner.nextInt();

            if (inputAct == account && inputPass == passWord){
                System.out.println("账号密码正确，登录成功");
                break;
            }else {
                if (3-num > 0) {
                    System.out.println("账号或密码错误，请重新输入，您还有" + (3 - num) + "次机会");
                }else{
                    System.out.println("输入次数以用尽，自动退出");
                }
            }
            num++;
        }
    }
}

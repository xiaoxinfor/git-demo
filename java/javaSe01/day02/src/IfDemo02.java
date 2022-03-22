import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-14:48
 * @Since:jdk1.8
 * @Description:
 */
public class IfDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();

        if (month >= 1 && month <= 12){
            if (month >= 3 && month <=5){
                System.out.println(month + "月是春季");
            }else if (month >= 6 && month <= 8){
                System.out.println(month + "月是夏季");
            }else if (month >= 9 && month <= 11){
                System.out.println(month + "月是秋季");
            }else{
                System.out.println(month + "月是冬季");
            }
        }else{
            System.out.println("请输入正确的月份。");
        }
    }
}

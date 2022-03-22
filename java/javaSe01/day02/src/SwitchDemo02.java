import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-15:32
 * @Since:jdk1.8
 * @Description:计算车费
 */
public class SwitchDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择车型（1：快车、2：专车、3：商务车）：");
        int car = scanner.nextInt();
        System.out.println("请输入公里数");
        double far = scanner.nextDouble();

        double carPrice = 0.0;
        switch (car){
            case 1:
                if (far <= 3){
                    carPrice = 10;
                }else {
                    int ifar = (int)far;
                    if (far > ifar){
                        ifar++;
                    }
                    carPrice = 10 + (ifar - 3) * 5;
                }
                break;
                case 2:
                if (far <= 3){
                    carPrice = 15;
                }else {
                    int ifar = (int)far;
                    if (far > ifar){
                        ifar++;
                    }
                    carPrice = 15 + (ifar - 3) * 8;
                }
                break;
                case 3:
                if (far <= 3){
                    carPrice = 20;
                }else {
                    int ifar = (int)far;
                    if (far > ifar){
                        ifar++;
                    }
                    carPrice = 20 + (ifar - 3) * 10;
                }
                break;
                default:
                    System.out.println("请输入正确的数据");
        }
        System.out.println("需支付" + carPrice + "元车费");
    }
}

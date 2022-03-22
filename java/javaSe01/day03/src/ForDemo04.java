/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-15:17
 * @Since:jdk1.8
 * @Description:
 */
public class ForDemo04 {
    public static void main(String[] args) {
        for (int num = 1; num <= 100; num++) {
            boolean b = true;

            for (int i = 2; i < num; i++) {
                if (num % i == 0){
                    b = false;
                    break;
                }
            }
            if (b){
                System.out.println(num + "是素数！");
            }
        }
    }
}
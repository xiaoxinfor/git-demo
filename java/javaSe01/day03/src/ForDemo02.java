/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-14:50
 * @Since:jdk1.8
 * @Description:
 */
public class ForDemo02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 11 - i; j >= 1; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}

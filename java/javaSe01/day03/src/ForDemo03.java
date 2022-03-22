/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-14:56
 * @Since:jdk1.8
 * @Description:
 */
public class ForDemo03 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}

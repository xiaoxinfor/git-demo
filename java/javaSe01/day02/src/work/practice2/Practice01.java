package work.practice2;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-20:25
 * @Since:jdk1.8
 * @Description:求1到100之间所有能被3整除的整数的和以及个数
 */
public class Practice01 {
    public static void main(String[] args) {
        int n = 1, ge = 0, sum = 0;
        while (n <= 100) {
            if (n % 3 == 0) {
                ge++;
                sum += n;
            }
            n++;
        }
        System.out.println("和：" + sum);
        System.out.println("个数：" + ge);
    }
}

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-16:36
 * @Since:jdk1.8
 * @Description:
 */
public class WhileDemo01 {
    public static void main(String[] args) {
        int n = 100,sum = 0;
        while (n >= 1){
            sum += n;
            n--;
        }
        System.out.println(sum);

        //偶数的个数以及求和
        int m = 1,sum1 = 0,ge = 0;
        while (m <= 100){
            if (m % 2 == 0){
                sum1 += m;
                ge++;
            }
            m++;
        }
        System.out.println("偶数个数为" + ge);
        System.out.println("偶数的和为" + sum1);
    }
}

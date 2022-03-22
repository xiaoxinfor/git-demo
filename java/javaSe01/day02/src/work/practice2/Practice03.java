package work.practice2;


/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-21:00
 * @Since:jdk1.8
 * @Description:猴子第一天摘下若干个桃子
 */
public class Practice03 {
    public static void main(String[] args) {
        int i = 10;//天数
        int j = 1;//第十天桃子个数
        do {
            j = (j + 1) * 2;
            i--;
        } while (i > 1);
        System.out.println(j);
    }
}

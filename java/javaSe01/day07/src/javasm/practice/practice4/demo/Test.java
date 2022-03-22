package javasm.practice.practice4.demo;

import javasm.practice.practice4.bean.Counter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:41
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Counter counter1 = new Counter(1,2,"+");
        System.out.println(counter1.yunSuan());
    }
}

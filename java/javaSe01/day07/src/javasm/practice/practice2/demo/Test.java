package javasm.practice.practice2.demo;

import javasm.practice.practice2.bean.JuXing;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:08
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //创建矩形对象
        JuXing juXing1 = new JuXing(20,30);
        System.out.println("矩形的面积为" +juXing1.mianJi());
        System.out.println("矩形的周长为" + juXing1.zhouChang());
    }
}

package javasm.practice.practice3.demo;

import javasm.practice.practice3.bean.People;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:24
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        People people1 = new People(01,"小李",29);
        People people2 = new People(02,"小白",20);
        System.out.println(people1);
        System.out.println(people2);
        //创建了几个对象
        System.out.println("创建了" + People.ciShu + "个对象");
        people1.biJiao(people2);
    }
}

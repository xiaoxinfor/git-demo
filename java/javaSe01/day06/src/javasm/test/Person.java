package javasm.test;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-15:16
 * @Since:jdk1.8
 * @Description:
 */
public class Person {
    public int age;
    public String name;
    public String [] likes;

    public Person(){}//无参构造方法
    public Person(int age,String name,String[] likes){//有参构造
        this.age = age;
        this.name = name;
        this.likes =likes;
    }

    public void sleep() {
        System.out.println("会睡觉");
    }
    public void eat() {
        System.out.println("会吃饭");
    }

    public void show(){
        System.out.println(age);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
    }

    public void addLikes(){
        //获取当前对象的爱好
        String[] likes = this.likes;
        //对爱好数组进行扩容
        likes = Arrays.copyOf(likes,likes.length + 1);
        likes[likes.length-1] = "游戏";
        //将扩容后的数组重新赋给当前对象
        this.likes = likes;
    }

}

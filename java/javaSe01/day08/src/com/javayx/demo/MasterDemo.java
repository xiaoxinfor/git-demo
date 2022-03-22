package com.javayx.demo;

import com.javayx.bean.Cat;
import com.javayx.bean.Dog;
import com.javayx.bean.Master;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-14:21
 * @Since:jdk1.8
 * @Description:
 */
public class MasterDemo {
    public static void main(String[] args) {
        //创建对象
        Master master = new Master();
        Cat cat = new Cat();
        Dog dog = new Dog();
        master.feed(cat);//master的feed方法中的参数实际上是父类型的引用，这一步是把子类型的对象当做参数传递过去，完成了多态的应用：Pet pet = new Cat();
        master.feed(dog);
    }
}

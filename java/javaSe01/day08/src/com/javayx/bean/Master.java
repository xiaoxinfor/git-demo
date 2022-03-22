package com.javayx.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-14:15
 * @Since:jdk1.8
 * @Description:主人类
 */
public class Master {
    /**
     * 喂宠物吃
     * @param pet
     */
    public void feed(Pet pet){
        //编译的时候编译器发现是pet是Pet类，会去Pet类中找eat方法，找到了，编译通过
        //运行的时候，底层实际的对象是什么，就自动调用到该实际对象对应的eat方法上
        //这就是多态的使用
        //多态的好处是，在有新的需求时，不必再原来的基础上增加修改代码，而可以直接增加一个新的类，提高了程序的扩展力
        //符合ocp原则
        pet.eat();
    }
}

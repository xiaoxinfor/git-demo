package com.javayx.test;

import com.javayx.service.lambda.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-14:54
 * @Since:jdk1.8
 * @Description:lambda表达式简写
 */
public class LambdaTest01 {
    public static void main(String[] args) {
        //无参无返回值
        /**
         * 当lambda表达式中只有一行代码时，可以将大括号{}删掉
         */
        NoResultNoParams noResultNoParams = () -> System.out.println("这是一个无参无返回值的方法");
        noResultNoParams.test();

        //有参无返回值
        /**
         * 当lambda表达式中有多个参数时，
         */
        NoResultYesParams noResultYesParams = (a,b) -> System.out.println("和为" + (a + b));
        noResultYesParams.test(10,20);

        //无参有返回值
        YesResultNoParams yesResultNoParams = () -> "这是一个无参有返回值的方法";
        System.out.println(yesResultNoParams.test());

        //有参有返回值
        YesResultYesParams yesResultYesParams = (a,b) -> "差为" + (a - b);
        System.out.println(yesResultYesParams.test(30,10));

        //一个参数lambda表达式简化
        OneParams oneParams = a -> System.out.println("a为" + a);
        oneParams.test(2);
    }
}

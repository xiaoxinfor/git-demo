package com.javayx.test;

import com.javayx.service.lambda.NoResultNoParams;
import com.javayx.service.lambda.NoResultYesParams;
import com.javayx.service.lambda.YesResultNoParams;
import com.javayx.service.lambda.YesResultYesParams;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-13:36
 * @Since:jdk1.8
 * @Description:
 */
public class LambdaTest {
    public static void main(String[] args) {
        /**
         * lambda表达式
         * ()->{
         *     方法体;
         * };
         */
        //无参无返回值
        NoResultNoParams noResultNoParams = () ->{
            System.out.println("这是一个无参无返回值的方法");
        };
        noResultNoParams.test();

        //有参无返回值
        NoResultYesParams noResultYesParams = (int a,int b) ->{
            System.out.println("和为" + (a + b));
        };
        noResultYesParams.test(10,20);

        //无参有返回值
        YesResultNoParams yesResultNoParams = () ->{
            return "这是一个无参有返回值的方法";
        };
        System.out.println(yesResultNoParams.test());

        //有参有返回值
        YesResultYesParams yesResultYesParams = (int a,int b) ->{
            return "差为" + (a - b);
        };
        System.out.println(yesResultYesParams.test(30,10));
    }

}

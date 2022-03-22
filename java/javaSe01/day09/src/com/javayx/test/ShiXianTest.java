package com.javayx.test;

import com.javayx.service.ShiXianJieKouService;
import com.javayx.service.impl.ShiXianImpl;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-12:03
 * @Since:jdk1.8
 * @Description:
 */
public class ShiXianTest {
    public static void main(String[] args) {
        //实现类实现类实现接口
        ShiXianJieKouService shiXianJieKouService = new ShiXianImpl();
        shiXianJieKouService.test(5,5);

        //内部类
        ShiXianJieKouService shiXianJieKouService1 = new ShiXianJieKouService() {
            @Override
            public void test(int a, int b) {
                System.out.println("差:" + (a - b));
            }
        };
        shiXianJieKouService1.test(10,5);

        /**
         * 使用lambda表达式实现接口
         * 注意：lambda表达式只能用于实现函数式接口
         * 函数式接口：在接口中有且只有一个抽象方法！
         */
        ShiXianJieKouService shiXianJieKouService2 = (int a,int b) ->{
            System.out.println("和：" + (a + b));
        };
        shiXianJieKouService2.test(10,20);

        /**
         * lambda表达式简写
         */
        ShiXianJieKouService shiXianJieKouService3 = (int a,int b) -> System.out.println("差：" + (a - b));
        shiXianJieKouService3.test(20,10);
    }
}

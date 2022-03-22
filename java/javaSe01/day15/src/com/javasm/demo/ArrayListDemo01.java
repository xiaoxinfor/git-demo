package com.javasm.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-15:14
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayListDemo01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("张三");
        arrayList.add("李四");
        arrayList.add("王五");
        arrayList.add("jack");
        arrayList.add("cat");

        Collection<String> collection = new ArrayList<>();
        collection.add("tom");
        collection.add("tom");
        collection.add("tom");
        collection.add("cat");
        collection.add("cat");
        collection.add("cat");
        collection.add("lili");

        arrayList.addAll(collection);
        //创建迭代器对象
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("----------------------------");
        boolean b = arrayList.removeIf((t) -> {
            if (t.equals("tom")) {
                return true;
            } else {
                return false;
            }
        });
        System.out.println("是否成功移除tom:" + b);
        for (String s : arrayList) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        arrayList.replaceAll((t)->{
            if(t.equals("cat")){
                return "tomcat";
            }
            return t;
        });
        arrayList.forEach((t)->{
            System.out.println(t);
        });
    }
}

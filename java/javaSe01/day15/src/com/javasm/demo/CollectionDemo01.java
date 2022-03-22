package com.javasm.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-10:24
 * @Since:jdk1.8
 * @Description:
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("你好");
        collection.add(123);
        collection.add(1234);
        collection.add(true);
        collection.add(new Date());
        collection.add('男');

        System.out.println("集合长度" + collection.size());
        Collection collection1 = new ArrayList();
        collection1.add("tom");
        collection1.add("lucy");
        collection1.add("jack");

        //将集合添加到集合中
        collection.add(collection1);//这个添加的是集合的地址
        collection.addAll(collection1);//这个添加的是集合中的每一个元素

        //判断是否包含
        collection.contains(1234);//true
        collection.retainAll(collection1);//true

        //遍历，使用迭代器对象遍历collection这个集合
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //移除元素
        collection.remove(123);
        collection.removeAll(collection1);//移除collection1中的元素
        collection.remove(collection1);//移除collection1的地址

        //保留
        collection.retainAll(collection1);//只保留collection1中的元素

        collection.clear();//清空所有元素
    }
}

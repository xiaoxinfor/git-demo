package com.javasm.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-11:33
 * @Since:jdk1.8
 * @Description:
 */
public class ListDemo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        //添加元素
        list.add(1234);
        list.add(12);
        list.add(1);
        list.add("tom");
        list.add("小白");
        list.add(true);
        list.add(new Date());

        //在指定索引处插入元素
        list.add(1, 123);//在索引1处插入123
        list.add(list.size(), "这是最后一个元素");//在末尾插入元素

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        System.out.println("--------------------------------------");
        //根据索引来移除元素
        list.remove(4);//移除索引4的元素
        System.out.println("索引为3的元素为"+list.get(3));//获取索引3处的元素

        //修改set--> 根据元素查找索引indexof。根据索引来修改数据
        String name = "小白";

        if (list.contains(name)) {
            int index = list.indexOf(name);
            list.set(index, "小黑");//将小白修改成了小黑
        } else {
            System.out.println(name + "在集合中不存在");
        }

        //for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------------------------------------");
        //增强for
        for (Object obj:list){
            System.out.println(obj);
        }

        System.out.println("--------------------------------");
        //for each
        list.forEach((a)->{
            System.out.println(a);
        });
        String s = new String();
        s.toString();
    }
}


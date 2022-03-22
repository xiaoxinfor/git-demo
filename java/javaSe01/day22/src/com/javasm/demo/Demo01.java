package com.javasm.demo;

import javafx.scene.web.WebHistory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-10:22
 * @Since:jdk1.8
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"小明", "小白", "小红"};
        while (true) {
            //菜单
            System.out.println("请选择");
            System.out.println("1、增加");
            System.out.println("2、查询");
            System.out.println("3、修改");
            System.out.println("4、删除");
            System.out.println("5、显示");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    //增加
                    names = ShuZu.add(names);
                    break;
                case 2:
                    System.out.println("请输入要查询的姓名");
                    String name = scanner.next();
                    int isin = ShuZu.select(names, name);
                    if (isin == -1) {
                        System.out.println("未查询到该姓名");
                    } else {
                        System.out.println("查询到该姓名，在数组中的索引为" + isin);
                    }
                    break;
                case 3:
                    names = ShuZu.update(names);
                    break;
                case 4:
                    names = ShuZu.delete(names);
                    break;
                case 5:
                    System.out.println(Arrays.toString(names));
                    break;
            }
        }
    }
}

class ShuZu {
    static Scanner scanner = new Scanner(System.in);

    /**
     * 增加数组元素
     *
     * @param names
     * @return
     */
    public static String[] add(String[] names) {
        System.out.println("请输入你要增加的姓名：");
        String addName = scanner.next();
        //先在数组中查询这个名字是否存在，如果不存在，就增加
        //调用select方法
        int isin = select(names, addName);
        if (isin != -1) {
            System.out.println(addName + "以在数组中,不用重复添加");
            return names;
        }
        //增加
        names = Arrays.copyOf(names, names.length + 1);//扩容
        //在最后一个位置增加元素
        names[names.length - 1] = addName;
        return names;
    }

    /**
     * 查询某个名字在数组中是否存在
     *
     * @param name
     * @return
     */
    public static int select(String[] names, String name) {
        //循环遍历数组
        //该元素在数组中的下标
        int index = -1;//没找到
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])) {//找到了
                index = i;
            }
        }
        if (index == -1) {
            return -1;
        }
        return index;
    }

    /**
     * 修改数组中的某个元素
     *
     * @param names
     * @return
     */
    public static String[] update(String[] names) {
        System.out.println("请输入您要修改的姓名");
        String oldName = scanner.next();
        //查询是否在数组中
        int isin = select(names, oldName);
        if (isin == -1) {
            System.out.println("未找到该姓名，不能修改");
            return names;
        }
        //找到了
        System.out.println("请输入修改后的姓名");
        String newName = scanner.next();
        names[isin] = newName;
        return names;
    }

    public static String[] delete(String[] names) {
        System.out.println("请输入你要删除的姓名：");
        String addName = scanner.next();
        //先在数组中查询这个名字是否存在，如果不存在，就不用删除
        //调用select方法
        int isin = select(names, addName);
        if (isin == -1) {
            System.out.println(addName + "不存在");
            return names;
        }
        //存在
        for (int i = isin; i < names.length - 1; i++) {
            names[i] = names[i + 1];
        }
        names = Arrays.copyOf(names, names.length - 1);
        return names;
    }
}

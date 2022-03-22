package com.javayx.demo;

import com.javayx.service.ArraySerive;
import com.javayx.service.impl.ArraySeriveImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-17:22
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayTest {
    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Scanner scanner = new Scanner(System.in);
        menu(nums,scanner);
    }

    public static void menu(int[] nums, Scanner scanner) {
        //实现接口
        ArraySerive arraySerive = new ArraySeriveImpl();
        boolean b = true;
        while (b) {
            System.out.println("1显示。2、增加。3、删除。4、修改。0、退出");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    arraySerive.show(nums);
                    break;
                case 2:
                    nums = arraySerive.add(nums,scanner);
                    break;
                case 3:
                    nums = arraySerive.delete(nums,scanner);
                    break;
                case 4:
                    nums = arraySerive.xiuGai(nums,scanner);
                    break;
                case 0:
                    b = false;
                    System.out.println("退出成功");
                    break;
            }
        }
    }
}

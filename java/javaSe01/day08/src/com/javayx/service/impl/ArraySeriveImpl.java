package com.javayx.service.impl;

import com.javayx.service.ArraySerive;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-17:16
 * @Since:jdk1.8
 * @Description:
 */
public class ArraySeriveImpl implements ArraySerive {
    @Override
    public void show(int[] nums) {
        System.out.println("显示数组元素");
        System.out.println(Arrays.toString(nums));
    }

    @Override
    public int[] add(int[] nums, Scanner scanner) {
        System.out.println("增加数组元素");
        System.out.println("请输入要增加的数字：");
        int input = scanner.nextInt();
        //扩容数组
        nums = Arrays.copyOf(nums, nums.length + 1);
        nums[nums.length - 1] = input;
        return nums;
    }

    @Override
    public int[] delete(int[] nums, Scanner scanner) {
        System.out.println("删除数组元素");
        System.out.println("请输入要删除的数字");
        int input = scanner.nextInt();
        //调用index方法来查找输入数字在数组中的索引
        int indexNum = index(nums, input);
        if (indexNum == -1) {
            System.out.println("没有找到该数字。");
            return nums;
        }
        for (int i = indexNum; i < nums.length - 1; i++) {
            //找到了数字，删除操作,将后一位数字填入前一位数字
            nums[i] = nums[i + 1];
        }
        //缩容操作
        nums = Arrays.copyOf(nums, nums.length - 1);
        return nums;
    }

    @Override
    public int[] xiuGai(int[] nums, Scanner scanner) {
        System.out.println("修改数组元素");
        System.out.println("请输入要修改的数字");
        int input = scanner.nextInt();
        int indexNum = index(nums,input);
        if (indexNum == -1){
            System.out.println("没有找到该数字。");
            return nums;
        }
        System.out.println("你想修改为：");
        int inputXiu = scanner.nextInt();
        nums[indexNum] = inputXiu;
        return nums;
    }

    /**
     * 查找某元素在数组中的索引
     */
    private int index(int[] nums, int input) {
        int indexNum = -1;//没找到该元素
        for (int i = 0; i < nums.length; i++) {
            if (input == nums[i]) {
                indexNum = i;//找到了输入的元素
                return indexNum;
            }
        }
        return indexNum;
    }
}

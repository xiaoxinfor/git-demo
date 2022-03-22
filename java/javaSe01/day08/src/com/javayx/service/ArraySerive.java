package com.javayx.service;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/7-17:13
 * @Since:jdk1.8
 * @Description:数组接口
 */
public interface ArraySerive {
    /**
     * 显示数组
     */
    void show(int[] nums);
    /**
     * 添加数组元素
     */
    int[] add(int[] nums, Scanner scanner);
    /**
     * 删除数组元素
     */
    int[] delete(int[] nums,Scanner scanner);
    /**
     * 修改
     */
    int[] xiuGai(int[] nums,Scanner scanner);
}

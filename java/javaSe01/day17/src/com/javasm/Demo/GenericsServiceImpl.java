package com.javasm.Demo;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-17:08
 * @Since:jdk1.8
 * @Description:
 */
public class GenericsServiceImpl<E> implements GenericService<E>{
    @Override
    public void show(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

    @Override
    public E[] add(E[] array, E e) {
        array = Arrays.copyOf(array,array.length+1);
        array[array.length -1] = e;
        return array;
    }

    @Override
    public E[] delete(E[] array, E e) {
        //找索引
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e){
                index = i;
            }
        }
        if (index == -1){
            System.out.println("没找到要删除的元素");
            return array;
        }
        for (int i = index; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        //缩容
        array = Arrays.copyOf(array,array.length-1);
        return array;
    }

    /**
     * 修改
     *
     * @param array
     * @param e
     * @param a
     */
    @Override
    public void update(E[] array, E e, E a) {
        //找索引
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e){
                index = i;
            }
        }
        if (index == -1){
            System.out.println("没找到要修改的元素");
            return;
        }
        array[index] = a;
    }
}

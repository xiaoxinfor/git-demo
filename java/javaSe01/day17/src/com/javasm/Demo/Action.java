package com.javasm.Demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-17:16
 * @Since:jdk1.8
 * @Description:
 */
public class Action {
    public static void main(String[] args) {
        GenericService<Integer> genericService = new GenericsServiceImpl<>();
        Integer array[] = {1, 2, 3, 4, 5, 6, 7};
        array = genericService.add(array, 99);
        genericService.show(array);
        array = genericService.delete(array, 99);
        genericService.show(array);

        GenericService<String> genericService1 = new GenericsServiceImpl<>();
        String arr[] = {"dd", "aa", "ddaq", "vv"};
        genericService1.show(arr);
        arr = genericService1.add(arr, "ll");
        arr = genericService1.delete(arr, "ddaq");
        genericService1.update(arr,"vv","VV");
        genericService1.show(arr);
    }
}

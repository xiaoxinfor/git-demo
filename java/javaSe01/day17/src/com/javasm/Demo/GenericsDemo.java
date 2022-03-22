package com.javasm.Demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-16:51
 * @Since:jdk1.8
 * @Description:
 */
public class GenericsDemo {
    public static void main(String[] args) {
        Integer array[] = {1,2,3,4,5,6,7};
        show(array);

        String string[] = {"ddd","dad","dadaw"};
        System.out.println(get(string));

        User arr[] = {new User("dd",1),new User("aa",2)};
        show(arr);
    }
    public static <T> void show(T[] array){
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static <T> T get(T[] array){
        return array[0];
    }
}

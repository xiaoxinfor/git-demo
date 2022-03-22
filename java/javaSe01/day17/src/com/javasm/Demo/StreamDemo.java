package com.javasm.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-15:32
 * @Since:jdk1.8
 * @Description:
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(9);
        System.out.println(list);
        Stream<Integer> stream = list.stream();
        List<Integer> collect = stream.distinct().collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> integers = list.stream().distinct().filter((i) -> {
            if (i == 5) {
                return false;
            } else {
                return true;
            }
        }).collect(Collectors.toList());
        System.out.println(integers);

        Collections.sort(list);
        System.out.println(list);


    }
}

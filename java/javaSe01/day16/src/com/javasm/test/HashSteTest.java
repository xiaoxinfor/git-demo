package com.javasm.test;

import com.javasm.dean.User;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-14:57
 * @Since:jdk1.8
 * @Description:
 */
public class HashSteTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(6);
        set.add(7);
        set.add(4);
        set.add(9);
        for (Integer integer : set) {
            System.out.println(integer);
        }

        Set<User> treeSet = new TreeSet<>();
        User user = new User(1,"aa");
        User user1 = new User(4,"7a");
        User user2 = new User(3,"a4");

        treeSet.add(user);
        treeSet.add(user1);
        treeSet.add(user2);

        System.out.println(treeSet);


//        Set<Integer> set1 = new TreeSet<>();
//        set1.add(5);
//        set1.add(7);
//        set1.add(6);
//        set1.add(88);
//        System.out.println(set1);
    }
}

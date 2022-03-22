package com.javasm.test;

import java.util.LinkedList;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-11:36
 * @Since:jdk1.8
 * @Description:
 */
public class LinkIistTset {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");
//        linkedList.add("cc");
//        linkedList.add("dd");
        linkedList.addFirst("11");
        linkedList.addLast("99");
        System.out.println(linkedList);
    }
}

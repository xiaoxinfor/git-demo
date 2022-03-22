package com.practice.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-21:40
 * @Since:jdk1.8
 * @Description:
 */
public class FootBall {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(16);
        String[] countries = {" 中国", "越南", "缅甸", "日本", "巴西", "西班牙", "葡萄牙", "阿根廷", "英国", "法国", "叙利亚", "俄罗斯", "德国", "意大利", "美国", " 荷兰"};
        for (String country : countries) {
            stringList.add(country);
        }
        System.out.println(stringList);

        Random random = new Random();


    }
}

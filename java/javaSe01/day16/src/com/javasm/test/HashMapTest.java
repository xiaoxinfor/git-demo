package com.javasm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-16:12
 * @Since:jdk1.8
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("age",18);
        map.put("name","mike");
        map.put("sex",'男');
        map.put("hight",1.85f);
        map.forEach((k,v)->{
            System.out.println(k + "-->" + v);
        });

        System.out.println(map.get("name"));


        Set<Map.Entry<String,Object>> set= map.entrySet();
        System.out.println(set);

        System.out.println(map.getOrDefault("gao", 180));

        map.replaceAll((k,v)->{
            if (k.equals("name")){
                return  "tom";
            }else {
                return v;
            }

        });
        System.out.println(map);
    }
}

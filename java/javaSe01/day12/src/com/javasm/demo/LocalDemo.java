package com.javasm.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/12-17:12
 * @Since:jdk1.8
 * @Description:
 */
public class LocalDemo {
    public static void main(String[] args) {
        //获取当前的年月
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //获取月份
        System.out.println(localDate.getDayOfMonth());
        //给定具体的时间
        LocalDate of = LocalDate.of(2020,1,29);
        System.out.println(of);

        //获取当前的时分秒
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //自定义时分秒
        LocalTime of1 = LocalTime.of(12,35);
        System.out.println(of1);

        //获取当前的年月日时分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //自定义时分秒
        LocalDateTime of2 = LocalDateTime.of(2022,1,13,19,01,41);
        System.out.println(of2);
    }
}

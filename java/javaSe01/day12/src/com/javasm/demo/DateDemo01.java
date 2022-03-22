package com.javasm.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/12-16:20
 * @Since:jdk1.8
 * @Description:
 */
public class DateDemo01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(getDataStr(date));
        System.out.println(date.getTime());
        Date date1 = new Date();
        System.out.println(date1);
        System.out.println(getHour(date1, date));
    }

    public static String getDataStr(Date date){
        //先判断
        if (date == null){
            throw new NullPointerException("日期不能为空");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss E");
        return simpleDateFormat.format(date);
    }

    public static long getHour(Date fromData,Date toData){
        long time = toData.getTime() - fromData.getTime();
        return time/1000/60/60;
    }
}

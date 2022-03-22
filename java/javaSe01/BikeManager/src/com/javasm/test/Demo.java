package com.javasm.test;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-22:43
 * @Since:jdk1.8
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date);
//        Date date1 = new Date(1641978436953L);
//        System.out.println(date1);

        //String转成Data
        String time = "2022-11-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
           dateTime = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateTime);
    }

}


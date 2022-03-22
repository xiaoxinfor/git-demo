package com.javasm.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/12-21:02
 * @Since:jdk1.8
 * @Description:
 */
public class Practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入日期（格式为：yyyy-MM-dd)");
        String time = scanner.next();
        System.out.println("请输入间隔的天数（后几天）");
        int day = scanner.nextInt();
        riQi(time,day);

    }

    public static void riQi(String time,int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String转成Date
        Date dateTime = null;
        try {
            dateTime = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long haoMiao1 = dateTime.getTime();
        //一天的毫秒数1000*60*60*24
        long haomiao2 = day*1000*60*60*24L;
        long haomiao = haoMiao1 + haomiao2;
        Date date = new Date(haomiao);
        //Date转string
        String strDay = sdf.format(date);
        System.out.println(strDay);
    }
}

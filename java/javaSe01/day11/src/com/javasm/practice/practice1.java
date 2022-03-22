package com.javasm.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/11-19:02
 * @Since:jdk1.8
 * @Description:
 */
public class practice1 {
    public static void main(String[] args) {
//        yi();
//        er();
//        san();
//        si();
//        wu();
//        liu();
//        qi();

    }

    /**
     * 第一题
     */
    public static void yi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String string = scanner.next();
        //逆序string
        //第一个与最后一个比较，第二个与倒数第二个比较.....循环string.length/2次，出现不同的说明不是回文字符
        //(0,string.length-1)(1,string.length-1-1)(2,string.length-1-2)
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                System.out.println(string + "不是回文字符串");
                return;
            }
        }
        System.out.println(string + "是回文字符串");
    }

    /**
     * 第二题
     */
    public static void er() {
        String st1 = "aabbcc";
        String st2 = "abcabc";
        //getBytes() 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中
        byte[] st1Bytes1 = st1.getBytes();
        byte[] st1Bytes2 = st2.getBytes();
        //排序
        Arrays.sort(st1Bytes1);
        Arrays.sort(st1Bytes2);
        if (Arrays.equals(st1Bytes1, st1Bytes2)) {
            System.out.println("这两个一致");
        } else {
            System.out.println("不一致");
        }
    }

    /**
     * 三
     */
    public static void san() {
        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("<" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + ">");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    /**
     * 四
     */
    public static void si() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String inputSt = scanner.next();
        //reverse()
        //导致该字符序列被序列的相反代替。
        StringBuffer stringBuffer = new StringBuffer(inputSt);
        StringBuffer a = stringBuffer.reverse();
        System.out.println(a);
    }

    /**
     * 五
     */
    public static void wu(){
        String st = " d d  f g  ff a ";
        st = st.replace(" ","");
        System.out.println(st);
    }
    /**
     * 六
     */
    public static void liu(){
        String st1 = "hanbasdnbafllgnbahjnbakqqqqlnbaxi";
        String st2 = "nba";
        int cishu = 0;//记录次数
        for (int i = 0; i < st1.length() - st2.length(); i++) {
            if(st2.equals(st1.substring(i,st2.length() + i))){
                cishu++;
            }
        }
        System.out.println(cishu);
    }

    /**
     * 七
     */
    public static void qi(){
        Scanner scanner = new Scanner(System.in);
        String result = "";
        while (true){
            System.out.println("请输入两个字母：");
            String input = scanner.next();
            //确保长度
            if (input.length() != 2){
                System.out.println("只能输入两个字符");
                continue;
            }
            boolean b = false;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isUpperCase(input.charAt(i)) && !Character.isLowerCase(input.charAt(i))){
                    System.out.println("只能输入字母");
                    b = true;
                }
            }
            if (b){
                continue;
            }else {
                result += input;
            }
            if (result.length() >= 6){
                System.out.println(result);
                break;
            }
        }
        //转数组
        char[] chars = result.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == 'a'){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 八
     */
    public static void ba(){

    }
}

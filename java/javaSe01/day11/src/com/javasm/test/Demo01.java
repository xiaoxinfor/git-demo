package com.javasm.test;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/11-15:20
 * @Since:jdk1.8
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Character character = '5';//自动装箱
        char ch = character;//自动拆箱
        Character character1 = new Character('c');

        System.out.println(character.compareTo(character1));
        System.out.println(character.equals(character1));
        //数字：哈希码值48-57
        System.out.println("是否是数字：" + Character.isDigit(character));
        System.out.println("是否是数字：" + Character.isDigit(49));

        System.out.println("判断是否是一个字母：" + Character.isLetter(character1));
        System.out.println("判断是否是一个字母：" + Character.isLetter(6));
    }
}

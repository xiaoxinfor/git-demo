package com.javasm.demo;

import com.javasm.action.BookAction;
import com.javasm.bean.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-14:53
 * @Since:jdk1.8
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请选择");
            System.out.println("1.添加数据");
            System.out.println("2.查询整表");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    for (int i = 0; i < 3; i++) {
                        Book book = new Book();
                        System.out.println("请输入增加书的ID，书名，数量，价格");
                        book.setId(scanner.nextInt());
                        book.setBookname(scanner.next());
                        book.setNums(scanner.nextInt());
                        book.setPrice(scanner.nextInt());
                        new BookAction().insert(book);
                    }
                    break;
                case 2:
                    List<Book> list = new BookAction().select();
                    System.out.println(list);
                    break;
            }
        }


    }
}

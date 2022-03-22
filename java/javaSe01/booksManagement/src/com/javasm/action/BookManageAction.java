package com.javasm.action;

import com.javasm.service.BookManageService;
import com.javasm.service.impl.BookManageServiceImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-18:35
 * @Since:jdk1.8
 * @Description:
 */
public class BookManageAction {
    BookManageService bookManageService;
    public BookManageAction() {
        bookManageService = new BookManageServiceImpl();
    }

    public void bookMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("书店管理销售系统>书籍管理");
            System.out.println("*********************************");
            System.out.println("1.查看书目");
            System.out.println("2.添加书籍");
            System.out.println("3.删除书籍");
            System.out.println("4.返 回 主 菜 单");
            System.out.println("*********************************");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    bookManageService.show();
                    break;
                case 2:
                    bookManageService.add();
                    break;
                case 3:
                    bookManageService.delete();
                    break;
                case 4:
                    return;
            }
        }
    }
}

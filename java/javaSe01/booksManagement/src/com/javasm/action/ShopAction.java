package com.javasm.action;

import com.javasm.service.BookManageService;
import com.javasm.service.ShopService;
import com.javasm.service.impl.BookManageServiceImpl;
import com.javasm.service.impl.ShowServiceImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-18:41
 * @Since:jdk1.8
 * @Description:
 */
public class ShopAction {
    ShopService shopService;
    public ShopAction() {
        shopService = new ShowServiceImpl();
    }

    /**
     * 购物结算
     */
    public void shopMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("书店管理销售系统>购物结算");
        System.out.println("*************书籍列表*************");
        BookManageService bookManageService = new BookManageServiceImpl();
        bookManageService.show();
        System.out.println("*********************************");
        System.out.println("请输入会员号：");
        int memberId = scanner.nextInt();
        while (true){
            System.out.println("请输入要购买的书籍编号：");
            int bookId = scanner.nextInt();
            System.out.println("请输入要购买的数量：");
            int num = scanner.nextInt();
            //加入购物车
            shopService.car(memberId,bookId,num);
            //显示
            shopService.show();
            System.out.println("是否继续？（y/n）");
            String anwer = scanner.next();
            if (anwer.equals("n")){
                //计算金额,清空购物车
                double price = shopService.buy(memberId);
                if (price == 0.01){
                    System.out.println("购买失败");
                    return;
                }
                System.out.println("金额总计：￥" + price);
                int jiFen = (int)price/10;
                System.out.println("消费积分：" + jiFen + "分");
                System.out.println("购买成功");
                return;
            }
        }
    }
}

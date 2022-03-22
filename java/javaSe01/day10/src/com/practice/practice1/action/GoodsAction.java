package com.practice.practice1.action;

import com.practice.practice1.bean.Goods;
import com.practice.practice1.exception.GoodException;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-21:18
 * @Since:jdk1.8
 * @Description:
 */
public class GoodsAction {
    //多个商品，创建商品类数组
    Goods[] goods;
    private Scanner scanner;
    private Goods[] gouWuChe;

    /**
     * 数据初始化
     */
    public GoodsAction() {
        //创建三个商品
        goods = new Goods[3];
        scanner = new Scanner(System.in);
        gouWuChe = new Goods[0];//购物车内无商品
        //填入商品信息
        goods[0] = new Goods(01, 3, "辣条", 10);
        goods[1] = new Goods(02, 23, "巧克力", 10);
        goods[2] = new Goods(03, 5, "鸡腿", 10);
    }

    public void bay() throws GoodException {
        System.out.println("请输入您要购买的商品");
        String inputName = scanner.next();
        Goods goods = chaXun(inputName);
        if (goods == null) {
            throw new GoodException("商品不存在");
        }
        System.out.println("请输入您要购买的数量");
        int inputNum = scanner.nextInt();
        if (inputNum > goods.getNum() || goods.getNum() == 0) {
            throw new GoodException("商品库存不足");
        }
        //购买成功加入购物车
        gouWuChe = Arrays.copyOf(gouWuChe, gouWuChe.length + 1);//扩容购物车
        //复制商品
        Goods buyGood = new Goods(goods.getId(),goods.getPrice(),goods.getName(),inputNum);
        gouWuChe[gouWuChe.length -1] = buyGood;
        goods.setNum(goods.getNum() - inputNum);//商品库存减掉购买的
        //需支付的金额
        double fuPrice = goods.getPrice()*inputNum;
        System.out.println("购买成功,您需支付" + fuPrice);

    }

    /**
     * 根据商品名称查找商品
     */
    public Goods chaXun(String name) {
        for (Goods good : goods) {
            if (name.equals(good.getName())) {
                return good;
            }
        }
        return null;//如果没找到，就返回空
    }

    /**
     * 商品信息
     */
    public void xinXi() {
        System.out.println("编号\t名称\t价格\t数量");
        for (Goods good : goods) {
            System.out.println(good.getId() + "\t\t" + good.getName() + "\t" + good.getPrice() + "\t\t" + good.getNum());
        }
    }


    /**
     * 菜单
     */
    public void menu() {
        while (true) {
            System.out.println("欢迎进入商店");
            System.out.println("1.选择商品");
            System.out.println("2.查看商品信息商品");
            System.out.println("3.退出");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    //创建对象调用方法
                    try {
                        bay();
                    } catch (GoodException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    xinXi();
                    break;
                case 3:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        new GoodsAction().menu();
    }
}

package com.javasm.action;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.dean.Goods;
import com.javasm.service.GoodsService;
import com.javasm.service.impl.GoodsServiceImpl;

import java.util.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-17:34
 * @Since:jdk1.8
 * @Description:
 */
public class GoodsAction {
    //商品列表
    private List<Goods> goodsList;
    //购物车（商品，数量）
    private Map<Goods,Integer> gouWUChe;
    private Scanner scanner;
    private GoodsService goodsService;

    //初始化
    public GoodsAction(){
        goodsList = new ArrayList<>();
        gouWUChe = new HashMap<>();
        new Scanner(System.in);
        scanner = new Scanner(System.in);
        goodsService = new GoodsServiceImpl();
        goodsList.add(new Goods(1,"辣条",3,10));
        goodsList.add(new Goods(2,"薯片",4,100));
        goodsList.add(new Goods(3,"瓜子",4,12));
        goodsList.add(new Goods(4,"花生",5,21));
        goodsList.add(new Goods(5,"啤酒",8,30));
    }

    public void menu(){
        while (true){
            System.out.println("商店");
            System.out.println("1.显示商品  2.购买商品  3.显示购物车  4.删除购物车商品  0.退出");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    goodsService.showGoods(goodsList);
                    break;
                case 2:
                    goodsService.buy(goodsList,gouWUChe,scanner);
                    break;
                case 3:
                    goodsService.showGouWuChe(gouWUChe);
                    break;
                case 4:
                    goodsService.deleteGouWuChe(gouWUChe,scanner);
                    break;
                case 0:
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

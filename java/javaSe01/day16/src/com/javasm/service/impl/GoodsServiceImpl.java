package com.javasm.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.dean.Goods;
import com.javasm.service.GoodsService;

import java.util.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-19:50
 * @Since:jdk1.8
 * @Description:
 */
public class GoodsServiceImpl implements GoodsService {
    /**
     * 显示商品
     *
     * @param arrayList
     */
    @Override
    public void showGoods(List<Goods> arrayList) {
        System.out.println("-----商品列表-----");
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("编号","名称","价格","库存");
        for (Goods goods : arrayList) {
            consoleTable.addBody(goods.getId().toString(),goods.getName(),goods.getPrice().toString(),goods.getCount().toString());
        }
        consoleTable.print();
    }

    /**
     * 购买商品
     *
     * @param arrayList
     * @param map
     * @param scanner
     */
    @Override
    public void buy(List<Goods> arrayList, Map<Goods, Integer> map, Scanner scanner) {
        System.out.println("请输入您要购买的商品编号及数量");
        int inputId = scanner.nextInt();
        int inputNum = scanner.nextInt();
        for (Goods goods : arrayList) {
            if (goods.getId() == inputId){
                if (inputNum>goods.getCount()){
                    System.out.println("该商品库存不足");
                    return;
                }
                if (map.containsKey(goods)){
                    inputNum = inputNum + map.get(goods);
                }
                map.put(goods,inputNum);
                System.out.println("购买成功");
            }
        }
    }

    /**
     * 查看购物车
     *
     * @param gouWUChe
     */
    @Override
    public void showGouWuChe(Map<Goods, Integer> gouWUChe) {
        System.out.println("购物车");
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("商品编号","商品名称","数量");
        gouWUChe.forEach((k,v)->{
            consoleTable.addBody(k.getId().toString(),k.getName(),v.toString());
        });
        consoleTable.print();
        Set<Goods> goodsSet = gouWUChe.keySet();
        int sum = 0;
        for (Goods goods : goodsSet) {
            sum += (goods.getPrice()*gouWUChe.get(goods));
        }
        System.out.println("需支付" + sum + "元");
    }

    /**
     * 删除购物车中的商品
     *
     * @param gouWUChe
     * @param scanner
     */
    @Override
    public void deleteGouWuChe(Map<Goods, Integer> gouWUChe, Scanner scanner) {
        System.out.println("删除购物车商品");
        System.out.println("请输入你要删除的商品编号及数量");
        int inputId = scanner.nextInt();
        int inputNum = scanner.nextInt();
        //获取所有的key，放在set集合中
        Set<Goods> key = gouWUChe.keySet();
        //遍历key
        for (Goods goods : key) {
            if (inputId == goods.getId()){
                if (inputNum>gouWUChe.get(goods)){
                    System.out.println("购物车中没有这么多商品");
                    return;
                }
                //删除的数量小于购物车中的数量
                if (inputNum<gouWUChe.get(goods)){
                    gouWUChe.put(goods,gouWUChe.get(goods)-inputNum);
                }else gouWUChe.remove(goods);
                System.out.println("删除成功");
            }
        }
    }
}

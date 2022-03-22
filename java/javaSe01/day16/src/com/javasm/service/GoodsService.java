package com.javasm.service;

import com.javasm.dean.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-19:50
 * @Since:jdk1.8
 * @Description:
 */
public interface GoodsService {
    void showGoods(List<Goods> arrayList);

    void buy(List<Goods> arrayList, Map<Goods, Integer> map, Scanner scanner);

    void showGouWuChe(Map<Goods, Integer> gouWUChe);

    void deleteGouWuChe(Map<Goods, Integer> gouWUChe, Scanner scanner);
}

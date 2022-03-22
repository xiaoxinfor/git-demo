package com.javasm.service;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/7-10:59
 * @Since:jdk1.8
 * @Description:
 */
public interface ShopService{
    /**
     * 将买的书加入购物车
     * @param memberId
     * @param bookId
     * @param num
     */
    void car(int memberId, int bookId, int num);

    /**
     * 显示购物车
     */
    void show();

    /**
     * 清空购物车
     */
    double buy(int memberId);
}

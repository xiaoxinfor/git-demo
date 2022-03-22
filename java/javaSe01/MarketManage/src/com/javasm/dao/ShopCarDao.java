package com.javasm.dao;

import com.javasm.bean.ShopCar;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-19:29
 * @Since:jdk1.8
 * @Description:
 */
public interface ShopCarDao {
    /**
     * 添加商品到购物车
     *
     * @param
     * @return
     */
    int addGoods(ShopCar shopCar);

    /**
     * 根据商品ID查询信息
     *
     * @param id
     * @param <T>
     * @return
     */
    <T> T selectByProId(int id);

    /**
     * 修改购物车中商品数量
     *
     * @param id
     * @return
     */
    int reviseNum(int num,double prices,int id);

    /**
     * 删除购物车中的商品
     *
     * @param id
     * @return
     */
    int deleteGoods(int id);

    /**
     * 清空购物车
     *
     * @return
     */
    int deleteCar();

    /**
     * 显示购物车列表
     *
     * @param <T>
     * @return
     */
    <T>List<T> showCar();

    /**
     * 统计购物车有几种不同的商品
     * @return
     */
    int count();

    /**
     * 计算商品总价格
     *
     * @return
     */
    double countPrices();

    /**
     * 更改会员余额，会员积分
     *
     * @param con
     * @param vipCard
     * @param jifen
     * @param money
     * @return
     */
    int reviseVip(Connection con, int vipCard, int jifen, double money);

    /**
     * 更改会员积分
     *
     * @param con
     * @param vipCard
     * @param jifen
     * @return
     */
    int reviseVip(Connection con, int vipCard, int jifen);

}

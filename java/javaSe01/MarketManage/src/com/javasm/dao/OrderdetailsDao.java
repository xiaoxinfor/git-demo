package com.javasm.dao;

import com.javasm.bean.PageInfo;
import com.javasm.bean.ShopCar;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-10:43
 * @Since:jdk1.8
 * @Description:
 */
public interface OrderdetailsDao {
    /**
     * 订单详情表中添加数据
     *
     * @param con
     * @param inFoID
     * @param shopCar
     * @return
     */
    int addTalis(Connection con, int inFoID, ShopCar shopCar);
    int addTalis(Connection con, int inFoID, int productId);

    /**
     * 查询订单记录(有条件)
     *
     * @param orderId
     * @param vipId
     * @param <T>
     * @return
     */
    <T> List<T> selectOrder(int orderId, int vipId, PageInfo pageInfo);
    <T> List<T> selectOrder(int orderId, int vipId);

    /**
     * 排行统计
     *
     * @param <T>
     * @return
     */
    <T> List<T> rank(int month);
    <T> List<T> rank();

    /**
     * 查询有多少订单
     *
     * @return
     */
    int count();
}

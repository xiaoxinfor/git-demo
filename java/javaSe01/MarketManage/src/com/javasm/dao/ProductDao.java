package com.javasm.dao;

import com.javasm.bean.PageInfo;
import com.javasm.bean.Product;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-21:24
 * @Since:jdk1.8
 * @Description:
 */
public interface ProductDao {
    /**
     * 总条数
     *
     * @return
     */
    int countProduct();

    /**
     * 查询所有商品信息
     *
     * @param <T>
     * @return
     */
    <T> List<T> queryProduct(PageInfo pageInfo);

    /**
     * 根据ID来查询
     *
     * @param id
     * @param <T>
     * @return
     */
    <T> T getProductById(int id);

    /**
     * 根据商品名称来查询
     * @param name
     * @param <T>
     * @return
     */
    <T> T getProductByName(String name);

    /**
     * 根据模糊名称来查询
     *
     * @param sName
     * @param <T>
     * @return
     */
    <T> List<T> getProductBySomeName(String sName);

    /**
     * 修改商品信息
     *
     * @param
     * @return
     */
    int reviseProduct(String productName,double price,int num, int discount,int typeid,int state,int id);

    /**
     * 修改商品库存（事务）
     * @param con
     * @param id
     * @param num
     * @return
     */
    int reviseProduct(Connection con,int id,int num);

    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 根据商品ID删除商品
     *
     * @param id
     * @return
     */
    int deleteProduct(int id);
}

package com.javasm.dao;

import com.javasm.bean.ProductType;

import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-11:10
 * @Since:jdk1.8
 * @Description:
 */
public interface ProductTypeDao {
    /**
     * 查询类型信息
     *
     * @param <T>
     * @return
     */
    <T> List<T> queryType();

    <T> List<T> queryType(int flagParent);

    /**
     * 商品表与商品类型表联查
     *
     * @param <T>
     * @return
     */
    <T> List<T> queryProAndType(int id);

    /**
     * 根据商品类型ID查询类型信息
     *
     * @param id
     * @param <T>
     * @return
     */
    <T> T getTypeById(int id);

    /**
     * 根据类型名称来查询
     *
     * @param typeName
     * @param <T>
     * @return
     */
    <T> T getTypeByName(String typeName);

    /**
     * 查询该父类型下有没有子类型
     *
     * @param parentID
     * @param <T>
     * @return
     */
    <T> T getTypeByFID(int parentID);

    /**
     * 查询该父类型下有没有商品
     *
     * @param <T>
     * @return
     */
    <T> List<T> getTypeByProId();

    /**
     * 删除商品类型
     *
     * @param id
     * @return
     */
    int deleteType(int id);

    /**
     * 添加父类型
     *
     * @param productType
     * @return
     */
    int addType(ProductType productType);

    /**
     * 添加子类型
     *
     * @param parentId
     * @param typeName
     * @return
     */
    int addType(int parentId, String typeName, Date creatTime);

    /**
     * 修改类型
     *
     * @param typeName
     * @return
     */
    int rereviseType(int parentid,String typeName,int flagParent,int id);
}

package com.javapractice.dao;

import com.javapractice.bean.Area;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-19:38
 * @Since:jdk1.8
 * @Description:
 */
public interface SelectCityDao {
    /**
     * 查询所有省份
     *
     * @param <T>
     * @return
     */
    <T> List<T> allProvince();

    /**
     * 查询市
     *
     * @param parentId
     * @param <T>
     * @return
     */
    <T> List<T> getCityById(int parentId);
}

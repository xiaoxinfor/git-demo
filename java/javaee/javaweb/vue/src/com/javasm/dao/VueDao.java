package com.javasm.dao;

import com.javasm.bean.VueTb;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-19:37
 * @Since:jdk1.8
 * @Description:
 */
public interface VueDao {
    /**
     * 查询整张表的所有数据
     *
     * @param <T>
     * @return
     */
    <T> List<T> selectAllVue();

    /**
     * 添加
     *
     * @param vueTb
     * @return
     */
    int add(VueTb vueTb);
}

package com.javasm.dao;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-20:08
 * @Since:jdk1.8
 * @Description:
 */
public interface GiftDao {
    /**
     * 查询奖品
     *
     * @param <T>
     * @return
     */
    <T>List<T> selectGift();
}

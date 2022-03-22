package com.javasm.dao;

import com.javasm.bean.Deliver;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-16:10
 * @Since:jdk1.8
 * @Description:
 */
public interface DeliverDao {
    /**
     * 查询所有帖子
     *
     * @param <T>
     * @return
     */
    <T> List<T> selectDel();



}

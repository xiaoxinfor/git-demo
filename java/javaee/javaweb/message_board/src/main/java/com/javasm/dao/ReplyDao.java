package com.javasm.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-19:30
 * @Since:jdk1.8
 * @Description:
 */
public interface ReplyDao {
    /**
     * 增加一条回复
     *
     * @param dId
     * @param rContent
     * @param uId
     * @return
     */
    Integer addReply(@Param("dId") Integer dId, @Param("rContent") String rContent, @Param("uId") Integer uId);

    /**
     * 查询回复
     *
     * @param dId
     * @param <T>
     * @return
     */
    <T> List<T> selectSomeReply(@Param("dId") Integer dId);
}

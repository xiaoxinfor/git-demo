package com.javasm.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-9:54
 * @Since:jdk1.8
 * @Description:
 */
public interface OrderinfoDao {
    /**
     * 增加
     *
     * @param con
     * @param vipId
     * @param prices
     * @param payType
     * @return
     */
    int addOrdInfo(Connection con,int id, int vipId, double prices, Date date, int payType);

    /**
     * 查询
     *
     * @param <T>
     * @return
     */
    <T> T selectInfo();
}

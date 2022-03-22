package com.javasm.dao.impl;

import com.javasm.bean.Gift;
import com.javasm.dao.GiftDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-20:08
 * @Since:jdk1.8
 * @Description:
 */
public class GiftDaoImpl implements GiftDao {
    @Override
    public <T> List<T> selectGift() {
        String sql = "select * from gift";
        return JDBCUtils.executeQuery(sql,Gift.class);
    }
}

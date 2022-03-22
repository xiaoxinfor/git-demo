package com.javapractice.dao.impl;

import com.javapractice.bean.Area;
import com.javapractice.dao.SelectCityDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-19:40
 * @Since:jdk1.8
 * @Description:
 */
public class SelectCityDaoImpl implements SelectCityDao {
    @Override
    public <T> List<T> allProvince() {
        String sql = "select * from area where parentId = 0";
        return JDBCUtils.executeQuery(sql,Area.class);
    }

    @Override
    public <T> List<T> getCityById(int parentId) {
        String sql = "select * from area where parentId = ?";
        return JDBCUtils.executeQuery(sql,Area.class,parentId);
    }
}

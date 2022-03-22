package com.javasm.dao.impl;

import com.javasm.bean.VueTb;
import com.javasm.dao.VueDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-19:39
 * @Since:jdk1.8
 * @Description:
 */
public class VueDaoImpl implements VueDao {
    @Override
    public <T> List<T> selectAllVue() {
        String sql = "select * from vuetb";
        return JDBCUtils.executeQuery(sql,VueTb.class);
    }

    @Override
    public int add(VueTb vueTb) {
        String sql = "insert into vuetb values(null,?,?,?)";
        return JDBCUtils.executeUpdate(sql,vueTb.getUserName(),vueTb.getAge(),vueTb.getSex());
    }
}

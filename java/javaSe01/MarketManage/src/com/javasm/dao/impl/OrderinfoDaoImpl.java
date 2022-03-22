package com.javasm.dao.impl;

import com.javasm.bean.Orderinfo;
import com.javasm.dao.OrderinfoDao;
import com.javasm.utils.JDBCUtils;

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
public class OrderinfoDaoImpl implements OrderinfoDao {
    @Override
    public int addOrdInfo(Connection con,int id, int vipId, double prices, Date date, int payType) {
        String sql = "insert into orderinfo values(?,?,?,?,?)";
        return JDBCUtils.insert(sql,con,id,vipId,prices,date,payType);
    }

    @Override
    public <T> T selectInfo() {
        String sql = "select * from orderinfo order by id desc limit 1;";
        return JDBCUtils.get(sql,Orderinfo.class);
    }
}

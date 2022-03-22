package com.javasm.dao.impl;

import com.javasm.bean.MoveBooking;
import com.javasm.bean.PageInfo;
import com.javasm.dao.MoveBookingDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-20:43
 * @Since:jdk1.8
 * @Description:
 */
public class MoveBookingDaoImpl implements MoveBookingDao {
    @Override
    public int insert(MoveBooking booking) {
        String sql = "INSERT into movebooking VALUES(null,?,?,?,?,?,0);";
        return JDBCUtils.executeUpdate(sql,booking.getArea(),booking.getCartype(),booking.getMovedate(),booking.getContact(),booking.getPhone());
    }

    @Override
    public <T> List<T> selectAll() {
        String sql = "select * from movebooking;";
        return JDBCUtils.executeQuery(sql,MoveBooking.class);
    }

    @Override
    public <T> List<T> selectPage(PageInfo pageInfo,String name) {
        String sql = "select * from movebooking where 1 = 1 ";
        if (name != null && !"".equals(name)){
            sql += "and cartype like '%" + name + "%'";
        }
        sql += " limit ?,?";
        return JDBCUtils.executeQuery(sql,MoveBooking.class,pageInfo.getStartIndex(),pageInfo.getPageSize());
    }

    @Override
    public int selectCount(String name) {
        String sql = "select count(id) from movebooking where 1 = 1";
        if (name != null && !"".equals(name)){
            sql += " and cartype like '%" + name + "%'";
        }
        return JDBCUtils.count(sql);
    }

    @Override
    public <T> T selectMove(Integer id) {
        String sql = "select * from movebooking where id = ?";
        return JDBCUtils.get(sql,MoveBooking.class,id);
    }

    @Override
    public int updateMove(Integer id,Integer state) {
        String sql = "update movebooking set state = ? where id = ?";
        return JDBCUtils.executeUpdate(sql,state,id);
    }

    @Override
    public int deleteMove(Integer id) {
        String sql = "delete from movebooking where id = ?";
        return JDBCUtils.executeUpdate(sql,id);
    }
}

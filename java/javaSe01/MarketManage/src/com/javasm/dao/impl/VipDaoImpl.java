package com.javasm.dao.impl;

import com.javasm.bean.Vip;
import com.javasm.dao.VipDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-16:02
 * @Since:jdk1.8
 * @Description:
 */
public class VipDaoImpl implements VipDao {
    @Override
    public <T> T selectVipByCardNum(int cardNumber) {
        String sql = "select * from vip where cardnumber = ?";
        return JDBCUtils.get(sql,Vip.class,cardNumber);
    }

    @Override
    public <T> List<T> selectVip() {
        String sql = "select * from vip";
        return JDBCUtils.executeQuery(sql,Vip.class);
    }

    @Override
    public int addVip(Vip vip) {
        String sql = "insert into vip values(null,?,?,?,?,?,?,null,?);";
        return JDBCUtils.executeUpdate(sql,vip.getCardnumber(),vip.getVipname(),vip.getIphone(),vip.getJifen(),vip.getMoney(),vip.getCreateTime(),vip.getPwd());
    }

    @Override
    public int reviseVip(Vip vip) {
        StringBuilder sql = new StringBuilder("update vip set cardnumber = " + vip.getCardnumber());
        if (!vip.getVipname().equals("")){
            sql.append(" ,vipname = '" + vip.getVipname() + "'");
        }
        if (!vip.getIphone().equals("")){
            sql.append(" ,iphone = '" + vip.getIphone() + "'");
        }
        if (vip.getJifen() != 0){
            sql.append(" ,jifen = " + vip.getJifen());
        }
        if (vip.getMoney() != 0){
            sql.append(" ,money = " + vip.getMoney());
        }
        sql.append(" where cardnumber = " + vip.getCardnumber());
        return JDBCUtils.executeUpdate(sql.toString());
    }

    @Override
    public int reviseVip(int jifen,int cardnumber) {
        String sql = "update vip set jifen = ? where cardnumber = ?";
        return JDBCUtils.executeUpdate(sql,jifen,cardnumber);
    }

    @Override
    public int chargeVip(double money,int cardnumber) {
        String sql = "update vip set money = (money + ?) where cardnumber = ?";
        return JDBCUtils.executeUpdate(sql,money,cardnumber);
    }

    @Override
    public int deleteVip(int cardNumber) {
        String sql = "delete from vip where cardnumber = ?";
        return JDBCUtils.executeUpdate(sql,cardNumber);
    }
}

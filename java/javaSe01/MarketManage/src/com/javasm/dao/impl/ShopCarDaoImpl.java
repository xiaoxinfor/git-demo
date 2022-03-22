package com.javasm.dao.impl;

import com.javasm.bean.ShopCar;
import com.javasm.constants.Price;
import com.javasm.dao.ShopCarDao;
import com.javasm.utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-19:29
 * @Since:jdk1.8
 * @Description:
 */
public class ShopCarDaoImpl implements ShopCarDao {
    @Override
    public int addGoods(ShopCar shopCar) {
        String sql = "insert into shopcar values(?,?,?,?,?,?);";
        return JDBCUtils.executeUpdate(sql,shopCar.getProductid(),shopCar.getProductName(),shopCar.getPrice(),shopCar.getDiscount(),shopCar.getNum(),shopCar.getPrices());
    }

    @Override
    public <T> T selectByProId(int id) {
        String sql = "select * from shopcar where productid = ?;";
        return JDBCUtils.get(sql,ShopCar.class,id);
    }

    @Override
    public int reviseNum(int num,double prices,int id) {
        String sql = "update shopcar set num = ?,prices = ? where productid = ?;";
        return JDBCUtils.executeUpdate(sql,num,prices,id);
    }

    @Override
    public int deleteGoods(int id) {
        String sql = "delete from shopcar where productid = ?;";
        return JDBCUtils.executeUpdate(sql,id);
    }

    @Override
    public int deleteCar() {
        String sql = "delete from shopcar";
        return JDBCUtils.executeUpdate(sql);
    }

    @Override
    public <T> List<T> showCar() {
        String sql = "select * from shopcar";
        return JDBCUtils.executeQuery(sql,ShopCar.class);
    }

    @Override
    public int count() {
        String sql = "select count(productid) from shopcar;";
        return JDBCUtils.count(sql);
    }

    @Override
    public double countPrices() {
        String sql = "SELECT sum(prices) from shopcar;";
        return JDBCUtils.price(sql);
    }

    @Override
    public int reviseVip(Connection con, int vipCard, int jifen, double money) {
        String sql = "update vip set jifen = ?,money = ? where cardnumber = ?";
        return JDBCUtils.update(sql,con,jifen,money,vipCard);
    }

    @Override
    public int reviseVip(Connection con, int vipCard, int jifen) {
        String sql = "update vip set jifen = ? where cardnumber = ?";
        return JDBCUtils.update(sql,con,jifen,vipCard);
    }
}

package com.javasm.dao.impl;

import com.javasm.bean.*;
import com.javasm.dao.OrderdetailsDao;
import com.javasm.utils.JDBCUtils;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-10:44
 * @Since:jdk1.8
 * @Description:
 */
public class OrderdetailsDaoImpl implements OrderdetailsDao {
    @Override
    public int addTalis(Connection con, int inFoID, ShopCar shopCar) {
        String sql = "insert into orderdetails values(null,?,?,?,?,?,?);";
        return JDBCUtils.update(sql,con,inFoID,shopCar.getProductid(),shopCar.getPrice(),shopCar.getDiscount(),shopCar.getNum(),shopCar.getPrices());
    }

    @Override
    public int addTalis(Connection con, int inFoID, int productId) {
        String sql = "insert into orderdetails values(null,?,?,0,10,1,0);";
        return JDBCUtils.update(sql,con,inFoID,productId);
    }

    @Override
    public <T> List<T> selectOrder(int orderId, int vipId, PageInfo pageInfo) {
        StringBuilder sql =new StringBuilder("SELECT o1.orderid ,p.productName,o1.price,o1.discount,o1.num,o2.orderdate,o2.paytype,o1.prices\n" +
                "FROM orderdetails o1\n" +
                "LEFT JOIN orderinfo o2\n" +
                "on o1.orderid = o2.id\n" +
                "LEFT JOIN product p\n" +
                "on o1.productid = p.id where 1 = 1");
        if (orderId != 0){
            sql.append(" and o1.orderid = " + orderId);
        }
        if (vipId != 0){
            sql.append(" and o2.vipid = " + vipId);
        }
        sql.append(" limit ?,?");
        return JDBCUtils.executeQuery(sql.toString(),Order.class,pageInfo.getCount() * pageInfo.getPage(), pageInfo.getCount());
    }

    @Override
    public <T> List<T> selectOrder(int orderId, int vipId) {
        StringBuilder sql =new StringBuilder("SELECT o1.orderid ,p.productName,o1.price,o1.discount,o1.num,o2.orderdate,o2.paytype,o1.prices\n" +
                "FROM orderdetails o1\n" +
                "LEFT JOIN orderinfo o2\n" +
                "on o1.orderid = o2.id\n" +
                "LEFT JOIN product p\n" +
                "on o1.productid = p.id where 1 = 1");
        if (orderId != 0){
            sql.append(" and o1.orderid = " + orderId);
        }
        if (vipId != 0){
            sql.append(" and o2.vipid = " + vipId);
        }
        return JDBCUtils.executeQuery(sql.toString(),Order.class);
    }

    @Override
    public <T> List<T> rank(int month) {
        String sql = "SELECT p.productName name,SUM(o1.num) nums,p2.typeName type,MONTH(o2.orderdate) date1\n" +
                "FROM  orderdetails o1\n" +
                "LEFT JOIN orderinfo o2\n" +
                "on o1.orderid = o2.id\n" +
                "LEFT JOIN product p\n" +
                "on o1.productid = p.id\n" +
                "LEFT JOIN producttype p2\n" +
                "on p.typeid = p2.id\n" +
                "WHERE MONTH(o2.orderdate) =" + month + "\n" +
                "GROUP BY o1.productid, MONTH(o2.orderdate),p2.typeName\n" +
                "order BY SUM(o1.num) DESC\n" +
                "LIMIT 10;";
        return JDBCUtils.executeQuery(sql,Rank.class);
    }

    @Override
    public <T> List<T> rank() {
        String sql = "SELECT p.productName name,SUM(o1.num) nums,p2.typeName type\n" +
                "FROM  orderdetails o1\n" +
                "LEFT JOIN orderinfo o2\n" +
                "on o1.orderid = o2.id\n" +
                "LEFT JOIN product p\n" +
                "on o1.productid = p.id\n" +
                "LEFT JOIN producttype p2\n" +
                "on p.typeid = p2.id\n" +
                "GROUP BY o1.productid,p2.typeName\n" +
                "order BY SUM(o1.num) DESC\n" +
                "LIMIT 10;";
        return JDBCUtils.executeQuery(sql,Rank.class);
    }

    @Override
    public int count() {
        String sql = "select count(*) from orderdetails";
        return JDBCUtils.count(sql);
    }


}

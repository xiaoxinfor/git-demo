package com.javasm.dao.impl;

import com.javasm.bean.PageInfo;
import com.javasm.bean.ProAndProType;
import com.javasm.bean.Product;
import com.javasm.dao.ProductDao;
import com.javasm.utils.JDBCUtils;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.Connection;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-21:26
 * @Since:jdk1.8
 * @Description:
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public int countProduct() {
        String sql = "SELECT count(*) FROM product";
        return JDBCUtils.count(sql);
    }

    @Override
    public <T> List<T> queryProduct(PageInfo pageInfo) {
        String sql = "SELECT p1.id,p1.productName,p1.price,p1.num,p1.discount,p2.typeName,p1.state FROM product p1 left join producttype p2 on p1.typeid = p2.id limit ?,?";
        return JDBCUtils.executeQuery(sql, ProAndProType.class, pageInfo.getCount() * pageInfo.getPage(), pageInfo.getCount());
    }

    @Override
    public <T> T getProductById(int id) {
        String sql = "select * from product where id = ?";
        return JDBCUtils.get(sql, Product.class, id);
    }

    @Override
    public <T> T getProductByName(String name) {
        String sql = "select * from product where productName = ?";
        return JDBCUtils.get(sql, Product.class, name);
    }

    @Override
    public <T> List<T> getProductBySomeName(String sName) {
        StringBuffer sql = new StringBuffer("select * from product where productName like '");
        sql.append(sName + "%' or productName like '%" + sName +"%' or productName like '%" + sName + "'");
        return JDBCUtils.executeQuery(sql.toString(),Product.class);
    }

    @Override
    public int reviseProduct(String productName,double price,int num, int discount,int typeid,int state,int id) {
        StringBuilder sql = new StringBuilder("UPDATE product set id = " + id);
        if (!productName.equals("")){
            sql.append(" ,productName = '" + productName + "'");
        }
        if (price != 0.0){
            sql.append(" ,price = " + price);
        }
        if (num != -1){
            sql.append(" ,num = " + num);
        }
        if (discount != 0){
            sql.append(" ,discount =" + discount);
        }
        if (typeid != 0){
            sql.append(" ,typeid = " + typeid);
        }
        if (state != 0){
            sql.append(" ,state =" + state);
        }
        sql.append(" where id = " + id);
        return JDBCUtils.executeUpdate(sql.toString());
    }

    @Override
    public int reviseProduct(Connection con, int id, int num) {
        String sql = "update product set num = ? where id = ?;";
        return JDBCUtils.update(sql, con, num, id);
    }

    @Override
    public int addProduct(Product product) {
        String sql = "INSERT INTO product VALUES (null, ?, ?, ?, ?, ?,?);";
        return JDBCUtils.executeUpdate(sql, product.getProductName(), product.getPrice(), product.getNum(), product.getDiscount(), product.getTypeid(), product.getState());
    }

    @Override
    public int deleteProduct(int id) {
        String sql = "update product set state = 3 WHERE id = ?;";
        return JDBCUtils.executeUpdate(sql, id);
    }
}

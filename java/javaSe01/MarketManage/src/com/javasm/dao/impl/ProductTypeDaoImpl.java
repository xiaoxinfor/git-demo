package com.javasm.dao.impl;

import com.javasm.bean.ProAndProType;
import com.javasm.bean.ProductType;
import com.javasm.dao.ProductTypeDao;
import com.javasm.utils.JDBCUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-11:11
 * @Since:jdk1.8
 * @Description:
 */
public class ProductTypeDaoImpl implements ProductTypeDao {
    @Override
    public <T> List<T> queryType() {
        String sql = "select * from producttype;";
        return JDBCUtils.executeQuery(sql,ProductType.class);
    }

    @Override
    public <T> List<T> queryType(int flagParent) {
        String sql = "select id,typeName from producttype where flagParent = ?";
        return JDBCUtils.executeQuery(sql,ProductType.class,flagParent);
    }

    @Override
    public <T> List<T> queryProAndType(int id) {
        String sql = "SELECT * from product p1,producttype p2 WHERE p1.typeid = p2.id and p2.id = ?;";
        return JDBCUtils.executeQuery(sql,ProAndProType.class,id);
    }

    @Override
    public <T> T getTypeById(int id) {
        String sql = "select * from producttype where id = ?;";
        return JDBCUtils.get(sql,ProductType.class,id);
    }

    @Override
    public <T> T getTypeByName(String typeName) {
        String sql = "select * from producttype where typeName = ?;";
        return JDBCUtils.get(sql,ProductType.class,typeName);
    }

    @Override
    public <T> T getTypeByFID(int parentID) {
        String sql = "SELECT * FROM producttype WHERE parentId = ? and flagParent = 0;";
        return JDBCUtils.get(sql,ProductType.class,parentID);
    }

    @Override
    public <T> List<T> getTypeByProId() {
        String sql = "SELECT * FROM producttype p1,product p2 WHERE p1.id = p2.typeid and flagParent = 0;";
        return JDBCUtils.executeQuery(sql,ProAndProType.class);
    }

    @Override
    public int deleteType(int id) {
        String sql = "delete from producttype where id = ?";
        return JDBCUtils.executeUpdate(sql,id);
    }

    @Override
    public int addType(ProductType productType) {
        String sql = "INSERT INTO producttype VALUES (null, 0,?,1,?,null);";
        return JDBCUtils.executeUpdate(sql,productType.getTypeName(),productType.getCreateTime());
    }

    @Override
    public int addType(int parentId, String typeName, Date creatTime) {
        String sql = "INSERT INTO producttype VALUES (null, ?,?,0,?,null);";
        return JDBCUtils.executeUpdate(sql,parentId,typeName,creatTime);
    }

    @Override
    public int rereviseType(int parentid,String typeName,int flagParent,int id) {
        StringBuilder sql = new StringBuilder("update producttype set id = " + id);
        if (parentid != -1){
            sql.append(" ,parentid =" + parentid);
        }
        if (!typeName.equals("")){
            sql.append(" ,typeName = '" + typeName + "'");
        }
        if (flagParent != -1){
            sql.append(" ,flagParent = " + flagParent);
        }
        sql.append(" where id = " + id);
        return JDBCUtils.executeUpdate(sql.toString());
    }
}

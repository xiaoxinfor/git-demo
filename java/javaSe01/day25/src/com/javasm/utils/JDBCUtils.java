package com.javasm.utils;

import cn.hutool.db.Db;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-10:22
 * @Since:jdk1.8
 * @Description:
 */
public class JDBCUtils {
    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection(){
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 执行增删改
     *
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql,Object... params){
        int i = 0;
        Connection con = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            i = queryRunner.update(con,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(con);
        }
        return i;
    }

    /**
     * 查询，返回集合
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> executeQuery(String sql,Class clazz,Object... params){
        List<T> list = null;
        Connection con = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            list = queryRunner.query(con,sql,new BeanListHandler<T>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(con);
        }
        return list;
    }

    public static <T> T get(String sql,Class clazz,Object... params){
        T t = null;
        Connection con = JDBCUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            t = queryRunner.query(con,sql,new BeanHandler<T>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(con);
        }
        return t;
    }
}

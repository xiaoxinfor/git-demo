package com.javasm.utlis;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-20:22
 * @Since:jdk1.8
 * @Description:
 */
public class JDBCUtils {
    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
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
    public static int executeUpdate(String sql, Object... params) {
        int i = 0;
        Connection con = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            i = queryRunner.update(con, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return i;
    }

    /**
     * 查询，返回集合
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> executeQuery(String sql, Class clazz, Object... params) {
        List<T> list = null;
        Connection con = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            list = queryRunner.query(con, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return list;
    }

    /**
     * 查询单个
     *
     * @param sql
     * @param clazz
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T get(String sql, Class clazz, Object... params) {
        T t = null;
        Connection con = JDBCUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            t = queryRunner.query(con, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(con);
        }
        return t;
    }

    /**
     * 查询总价
     */
    public static double price(String sql) {
        double prices = 0.0;
        //获取连接
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                prices = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prices;
    }


    /**
     * 统计查询出来结果的条数
     *
     * @param sql
     * @param params
     * @return
     */
    public static int count(String sql, Object... params) {
        int count = 0;
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            count = queryRunner.query(connection, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 修改，删除，增加,事务
     *
     * @param sql
     * @param connection
     * @param params
     * @return
     */
    public static int update(String sql, Connection connection, Object... params) {
        int i = 0;
        QueryRunner queryRunner = new QueryRunner();
        try {
            i = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 新增：事务
     *
     * @param sql
     * @param connection
     * @param params
     * @return
     */
    public static int insert(String sql, Connection connection, Object... params) {
        int id = 0;
        try {
            id = new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}

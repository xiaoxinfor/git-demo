package com.javasm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-15:54
 * @Since:jdk1.8
 * @Description:
 */
public class JDBCUtils {
    /**
     * 注册驱动
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
     * 资源回收
     *
     * @param con
     * @param ps
     */
    public static void close(Connection con, PreparedStatement ps) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        //获取连接
        Connection con = getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int j = 0; j < params.length; j++) {
                    ps.setObject(j + 1, params[j]);
                }
            }
            //执行sql
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, ps);
        }
        return i;
    }

    /**
     * 查询
     *
     * @param sql
     * @param c
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> find(String sql, Class c, Object... params) {
        List<T> list = new ArrayList<>();
        //获取数据库连接
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            //传参数
            if (params != null && params.length > 0) {
                for (int j = 0; j < params.length; j++) {
                    ps.setObject(j + 1, params[j]);
                }
            }
            //执行查询
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                //创建对象
                Object obj = c.newInstance();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    //获取列名
                    String labeName = metaData.getColumnLabel(i);
                    //获取列对应的类型
                    String className = metaData.getColumnClassName(i);
                    //根据列名获取元素值
                    Object value = rs.getObject(labeName);
                    //赋值
                    invoke(labeName, className, obj, value, c);
                }
                //将数据存入集合
                list.add((T) obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return list;
    }

    public static <T> T get(String sql, Class c, Object... params) {
        T t = null;
        //获取数据库连接
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int j = 0; j < params.length; j++) {
                    ps.setObject(j + 1, params[j]);
                }
            }
            //执行查询
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = rs.getMetaData();
            if (rs.next()) {
                //创建对象
                Object obj = c.newInstance();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    //获取列名
                    String labeName = metaData.getColumnLabel(i);
                    //获取列对应的类型
                    String className = metaData.getColumnClassName(i);
                    //根据列名获取元素值
                    Object value = rs.getObject(labeName);
                    //赋值
                    invoke(labeName, className, obj, value, c);
                }
                t = (T) obj;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return t;
    }

    public static void invoke(String labeName, String className, Object obj, Object value, Class c) {
        //方法名
        String method = ClassUtils.getMethod(labeName);
        //数据类型
        Class c1 = ClassUtils.getC(className);
        try {
            Method declaredMethod = c.getDeclaredMethod(method, c1);
            declaredMethod.invoke(obj, value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

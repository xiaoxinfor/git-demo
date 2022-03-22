package com.javasm.utils;
import java.sql.*;
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

    public static void close(Connection con,PreparedStatement ps){
        try {
            if (con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null && !ps.isClosed()){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection con,PreparedStatement ps,ResultSet rs){
        try {
            if (con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null && !ps.isClosed()){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

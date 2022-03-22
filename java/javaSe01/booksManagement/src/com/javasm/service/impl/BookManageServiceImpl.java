package com.javasm.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.service.BookManageService;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-22:51
 * @Since:jdk1.8
 * @Description:
 */
public class BookManageServiceImpl implements BookManageService {
    private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    String driver = bundle.getString("driver");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");

    /**
     * 查看书目
     */
    @Override
    public void show() {
        System.out.println("书店管理销售系统>书籍管理>查看书籍");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            //获取数据库操作对象
            stm = con.createStatement();
            //执行sql语句
            String sql = "select * from t_books";
            rs = stm.executeQuery(sql);
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("编号", "书名", "价格");
            //处理查询结果集
            while (rs.next()) {//光标指向的行有数据时为true
                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                consoleTable.addBody(id, name, price);
            }
            consoleTable.print();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 添加书籍
     */
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("书店管理销售系统>书籍管理>添加书籍");
        Connection con = null;
        PreparedStatement ps = null;
        System.out.println("请输入要添加的书名");
        String name = scanner.next();
        System.out.println("请输入该书价格");
        double price = scanner.nextDouble();
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            //sql语句
            String sql = "insert into t_books (name,price) values(?,?)";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            //给占位符传值
            ps.setString(1, String.valueOf(name));
            ps.setString(2, String.valueOf(price));
            //执行sql
            ps.executeUpdate();
            System.out.println("添加成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除书籍
     */
    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("书店管理销售系统>书籍管理>添加书籍");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("请输入要删除的书名");
        String name = scanner.next();

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            //sql语句
            String sql = "select * from t_books where name = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            //处理查询结果集
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                System.out.println("找到书籍，编号为" + id);
                String sql1 = "delete from t_books where name = ?";
                ps = con.prepareStatement(sql1);
                ps.setString(1,name);
                ps.executeUpdate();
                System.out.println("删除成功");
                return;
            }
            System.out.println("没有找打相关书籍，请重新输入");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

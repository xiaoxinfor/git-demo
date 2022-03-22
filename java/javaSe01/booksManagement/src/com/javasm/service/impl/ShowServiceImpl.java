package com.javasm.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.service.ShopService;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/7-11:00
 * @Since:jdk1.8
 * @Description:
 */
public class ShowServiceImpl implements ShopService {
    private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    String driver = bundle.getString("driver");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");

    /**
     * 将买的书加入购物车
     *
     * @param memberId
     * @param bookId
     * @param num
     */
    @Override
    public void car(int memberId, int bookId, int num) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            //根据会员号查找会员信息
            String sql = "select * from t_members where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,memberId);
            rs = ps.executeQuery();
            if (!rs.next()){
                System.out.println("会员号不存在，请重新输入。");
                return;
            }
            //根据书的编号查找该书的价格
            String sql1 = "select price from t_books where id = ?";
            ps = con.prepareStatement(sql1);
            ps.setInt(1,bookId);
            rs = ps.executeQuery();
            if (rs.next()){
                double price = rs.getDouble(1);
                //sql语句
                String sql2 = "insert into t_shopcart (membersid,booksid,nums,price) values(?,?,?,?)";
                //获取预编译数据库操作对象
                ps = con.prepareStatement(sql2);
                //给占位符传值
                ps.setInt(1,memberId);
                ps.setInt(2,bookId);
                ps.setInt(3,num);
                ps.setDouble(4,price);
                //执行sql
                ps.executeUpdate();
                System.out.println("加入购物车成功");
                return;
            }
            System.out.println("该书籍不存在，请重新输入。");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 显示购物车
     */
    @Override
    public void show() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url,user,password);
            //sql语句
            String sql = "select b.name,s.price,s.price*s.nums from t_shopcart s left join t_books b on s.booksid = b.id";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("书名","单价","总价");
            //处理查询结果集
            while (rs.next()){
                String name = rs.getString(1);
                String price = rs.getString(2);
                String zPrice = rs.getString(3);
                consoleTable.addBody(name,price,zPrice);
            }
            consoleTable.print();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 清空购物车
     */
    @Override
    public double buy(int memberId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url,user,password);
            //sql语句
            String sql = "select sum(nums*price) zongJia from t_shopcart";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                double price = rs.getDouble(1);
                //计算积分
                int jiFen = (int)price/10;
                //sql语句
                //查询该会员原来的积分
                String sql1 = "select integral from t_members where id = ?";
                ps = con.prepareStatement(sql1);
                //给占位符传值
                ps.setInt(1,memberId);
                //处理查询结果集（执行）
                rs = ps.executeQuery();
                int integrar = 0;
                if (rs.next()){
                    integrar = rs.getInt(1);
                }
                //更新积分
                String sql2 = "update t_members set integral = ? where id = ?";
                ps = con.prepareStatement(sql2);
                ps.setInt(1,(jiFen + integrar));
                ps.setInt(2,memberId);
                //执行sql
                ps.executeUpdate();
                //清空购物车
                String sql3 = "delete from t_shopcart";
                ps = con.prepareStatement(sql3);
                ps.executeUpdate();
                return price;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0.01;
    }
}

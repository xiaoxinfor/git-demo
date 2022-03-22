package com.javasm.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.service.MemberService;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-19:45
 * @Since:jdk1.8
 * @Description:
 */
public class MemberServiceImpl implements MemberService {
    private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    String driver = bundle.getString("driver");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");

    /**
     * 显示所有会员信息
     */
    @Override
    public void show() {
        System.out.println("书店管理销售系统>会员管理>显示会员信息");
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
            String sql = "select * from t_members";
            rs = stm.executeQuery(sql);
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("会员号", "年龄", "积分");
            //处理查询结果集
//            System.out.println("会员号\t年龄\t积分");
            while (rs.next()) {//光标指向的行有数据时为true
                String id = rs.getString(1);
                String age = rs.getString(2);
                String integral = rs.getString(3);
//                System.out.println(id + "\t" + age + "\t" + integral);
                consoleTable.addBody(id, age, integral);
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
     * 添加会员信息
     */
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("书店管理销售系统>会员管理>添加会员信息");
        Connection con = null;
        PreparedStatement ps = null;
        //会员号以设置为主键递增
        System.out.println("请输入会员年龄");
        int age = scanner.nextInt();
        System.out.println("请输入会员积分");
        int integral = scanner.nextInt();
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            //sql语句
            String sql = "insert into t_members (age,integral) values(?,?)";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql);
            //给占位符传值
            ps.setString(1, String.valueOf(age));
            ps.setString(2, String.valueOf(integral));
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
     * 修改会员信息
     */
    @Override
    public void upadte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("书店管理销售系统>会员管理>修改会员信息");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("请输入会员号");
        int id = scanner.nextInt();

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            //sql语句
            String sql1 = "select * from t_members where id = ?";
            ps = con.prepareStatement(sql1);
            ps.setInt(1,id);
            //处理查询结果集
            rs = ps.executeQuery();
            while (rs.next()) {//有该会员号
                System.out.println("请输入会员年龄");
                int age = scanner.nextInt();
                System.out.println("请输入会员积分");
                int integral = scanner.nextInt();
                if (integral < 0) {
                    System.out.println("会员积分不能为负数");
                    return;
                }
                String sql2 = "update t_members set age = ?,integral = ? where id = ?";
                //获取预编译数据库操作对象
                ps = con.prepareStatement(sql2);
                //给占位符传值
                ps.setString(1, String.valueOf(age));
                ps.setString(2, String.valueOf(integral));
                ps.setString(3, String.valueOf(id));
                //执行sql
                ps.executeUpdate();
                System.out.println("修改成功");
                return;
            }
            System.out.println("没有该会员号，请重新输入");

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

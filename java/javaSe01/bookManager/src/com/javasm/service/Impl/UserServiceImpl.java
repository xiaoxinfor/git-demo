package com.javasm.service.Impl;

import com.javasm.service.UserService;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-19:32
 * @Since:jdk1.8
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private String driver = bundle.getString("driver");
    private String url = bundle.getString("url");
    private String user = bundle.getString("user");
    private String password = bundle.getString("password");


    /**
     * 注册
     */
    @Override
    public void reg(Scanner scanner) {
        System.out.println("图书管理系统>>>注册");
        //卡号四位数随机生成
        int randomId = (int) (Math.random() * 9000) + 1000;
        System.out.println("请输入用户名");
        String inputName = scanner.next();
        System.out.println("请输入密码");
        int inputPwd = scanner.nextInt();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, user, password);
            while (true) {
                //sql语句，查询卡号
                String sql1 = "select * from user where id = ?";
                ps = con.prepareStatement(sql1);
                ps.setInt(1, randomId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //随机生成的卡号已经存在，在重新生成
                    randomId = (int) (Math.random() * 9000) + 1000;
                }else {
                    break;
                }
            }
            //sql语句、注册
            String sql2 = "insert into user (id,name,pwd) values(?,?,?)";
            //获取预编译数据库操作对象
            ps = con.prepareStatement(sql2);
            //给占位符传值
            ps.setInt(1, randomId);
            ps.setString(2, inputName);
            ps.setInt(3,inputPwd);
            //执行sql
            ps.executeUpdate();
            System.out.println("注册成功，你的卡号为" + randomId);
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

    @Override
    public String log(Scanner scanner) {
        System.out.println("图书管理系统>>>注册");
        System.out.println("请输入账号");
        int inputId = scanner.nextInt();
        System.out.println("请输入密码");
        int inputPwd = scanner.nextInt();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            //sql语句
            String sql = "select * from user where id = ? and pwd = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,inputId);
            ps.setInt(2,inputPwd);
            rs = ps.executeQuery();
            if (rs.next()){
                String name = rs.getNString(2);
                System.out.println("登录成功");
                return name;
            }
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

        return null;
    }
}

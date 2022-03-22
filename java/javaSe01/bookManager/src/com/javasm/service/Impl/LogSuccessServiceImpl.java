package com.javasm.service.Impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.service.LogSuccessService;
import com.javasm.util.BookUtil;

import java.lang.management.MonitorInfo;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-21:20
 * @Since:jdk1.8
 * @Description:
 */
public class LogSuccessServiceImpl implements LogSuccessService {
    private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private String driver = bundle.getString("driver");
    private String url = bundle.getString("url");
    private String user = bundle.getString("user");
    private String password = bundle.getString("password");

    /**
     * 充值
     *
     * @param scanner
     * @param name
     */
    @Override
    public void charge(Scanner scanner, String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql1 = "select * from user where name = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, name);
            rs = ps.executeQuery();
            double money = 0.0;
            if (rs.next()) {
                money = rs.getDouble(4);
            }
            System.out.println("欢迎您" + name + "余额为" + money);
            System.out.println("请输入充值金额");
            double newMoney = scanner.nextDouble();
            //修改金额
            String sql2 = "update user set money = ? where name = ?";
            ps = con.prepareStatement(sql2);
            ps.setDouble(1, (money + newMoney));
            ps.setString(2,name);
            ps.executeUpdate();
            System.out.println("[充值成功，余额为：" + (money + newMoney) + "]");
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

    /**
     * 修改登录密码
     *
     * @param scanner
     * @param name
     */
    @Override
    public boolean xiuGai(Scanner scanner, String name) {
        System.out.println("图书管理系统>>>修改登录密码");


        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("请输入新密码");
            int newPwd = scanner.nextInt();
            //判断新密码是否和原密码相同
            String sql1 = "select pwd from user where name = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1,name);
            rs = ps.executeQuery();
            int pwd = -1;
            if (rs.next()){
                pwd = rs.getInt(1);
            }
            if (pwd == newPwd){
                System.out.println("新密码与原密码相同，修改失败");
                return false;
            }
            System.out.println("请确认新密码");
            int newPwd1 = scanner.nextInt();
            if (newPwd != newPwd1){
                System.out.println("修改失败，两次输入的密码不一致");
                return false;
            }
            //sql语句
            //修改密码
            String sql = "update user set pwd = ? where name = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,newPwd);
            ps.setString(2,name);
            ps.executeUpdate();
            System.out.println("修改成功，请重新登录");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
        return true;
    }

    /**
     * 显示图书信息
     */
    @Override
    public void show() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql1 = "select * from books";
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("图书编号", "图书名称", "作者","借出次数","是否借出");
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                Integer nums = rs.getInt(4);
                int isJie = rs.getInt(5);
                consoleTable.addBody(id.toString(),name,author,nums.toString(),BookUtil.getBookStateStr(isJie));
            }
            consoleTable.print();
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

    /**
     * 借书
     *
     * @param scanner
     */
    @Override
    public void jieshu(Scanner scanner,String name) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            //先显示图书信息
            show();
            System.out.println("图书管理系统>>>借阅图书");
            System.out.println("请输入你要借阅的图书编号");
            int inputId = scanner.nextInt();
            String sql1 = "select * from books where id = ?";
            ps = con.prepareStatement(sql1);
            ps.setInt(1,inputId);
            rs = ps.executeQuery();
            if (rs.next()){
                String name1 = rs.getString(2);
                String author = rs.getString(3);
                int nums = rs.getInt(4);
                //判断该书是否被借出
                int isjieChu = rs.getInt(5);
                if (isjieChu == 1){
                    System.out.println("抱歉，该书以被借出");
                    return;
                }
                System.out.println("图书信息为");
                System.out.println("书名：" + name1 + author + "借出次数：" + nums);
                //根据用户姓名查询id
                String sql2 = "select id from user where name = ?";
                ps = con.prepareStatement(sql2);
                ps.setString(1,name);
                rs = ps.executeQuery();
                if (rs.next()){
                    int userId = rs.getInt(1);
                    //将信息存入书架
                    String sql3 = "insert into shujia (userid,bookid) values(?,?)";
                    ps = con.prepareStatement(sql3);
                    ps.setInt(1,userId);
                    ps.setInt(2,inputId);
                    ps.executeUpdate();
                    System.out.println("借书成功");
                    //将借出状态修改为已借出
                    String sql4 = "update books set jiechu = 1 where id = ?";
                    ps = con.prepareStatement(sql4);
                    ps.setInt(1,inputId);
                    ps.executeUpdate();
                }
            }else {
                System.out.println("没有找到该书");
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
    }

    /**
     * 还书
     *
     * @param scanner
     * @param name
     */
    @Override
    public void huanShu(Scanner scanner, String name) {
        //显示当前账号借书信息
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            //根据用户姓名查询id
            String sql1 = "select id from user where name = ?";
            ps = con.prepareStatement(sql1);
            ps.setString(1,name);
            rs = ps.executeQuery();
            int userId = 0;
            if (rs.next()){
                userId = rs.getInt(1);
            }
            //判断该用户之前有没有借书
            String sql7 = "select * from shujia where userid = ?";
            ps = con.prepareStatement(sql7);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            if (!rs.next()){
                System.out.println("您还未借阅任何图书");
                return;
            }
            String sql2 = "select s.bookid,b.bookname,b.author,b.nums,b.jiechu from shujia s  left join books b on s.bookid = b.id where s.userid = ?";
            ps = con.prepareStatement(sql2);
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("图书编号", "图书名称", "作者","借出次数","是否借出");
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name1 = rs.getString(2);
                String author = rs.getString(3);
                Integer nums = rs.getInt(4);
                int isJie = rs.getInt(5);
                consoleTable.addBody(id.toString(),name1,author,nums.toString(),BookUtil.getBookStateStr(isJie));
            }
            consoleTable.print();

            System.out.println("请输入还书的编号");
            int inputId = scanner.nextInt();
            String sql3 = "delete from shujia where bookid = ?";
            ps = con.prepareStatement(sql3);
            ps.setInt(1,inputId);
            ps.executeUpdate();
            //此编号书籍的借出次数加1,先获取原书籍借书次数
            String sql4 = "select nums from books where id = ?";
            ps = con.prepareStatement(sql4);
            ps.setInt(1,inputId);
            rs = ps.executeQuery();
            int oldNum = 0;
            if (rs.next()){
                oldNum = rs.getInt(1);
            }
            String sql5 = "update books set nums = ? where id = ?";
            ps = con.prepareStatement(sql5);
            ps.setInt(1,(oldNum + 1));//借书次数加1
            ps.setInt(2,inputId);
            ps.executeUpdate();
            System.out.println("还书成功");
            //将借出状态修改为未借出
            String sql6 = "update books set jiechu = 0 where id = ?";
            ps = con.prepareStatement(sql6);
            ps.setInt(1,inputId);
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

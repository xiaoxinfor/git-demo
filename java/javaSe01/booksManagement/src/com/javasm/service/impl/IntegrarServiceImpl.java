package com.javasm.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.service.IntegralService;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/7-16:02
 * @Since:jdk1.8
 * @Description:
 */
public class IntegrarServiceImpl implements IntegralService {
    private ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    String driver = bundle.getString("driver");
    String url = bundle.getString("url");
    String user = bundle.getString("user");
    String password = bundle.getString("password");

    @Override
    public void show() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from t_gift";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("编号", "礼品名称", "积分");
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String jiFen = rs.getString(3);
                consoleTable.addBody(id, name, jiFen);
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
    public boolean yanZheng(int memberId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from t_members where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, memberId);
            rs = ps.executeQuery();
            if (rs.next()) {
                //有该会员号
                return true;
            }
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
        return false;
    }

    @Override
    public void getGift(int giftId, int memberId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql = "select jifen from t_gift where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, giftId);
            rs = ps.executeQuery();
            if (rs.next()) {
                //兑换该礼品所需要的积分
                int jifen = rs.getInt(1);
                String sql1 = "select integral from t_members where id = ?";
                ps = con.prepareStatement(sql1);
                //该会员所拥有的积分
                int inte = 0;
                ps.setInt(1, memberId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    inte = rs.getInt(1);
                }
                if (inte < jifen) {
                    System.out.println("积分不足以兑换该礼品");
                    return;
                }
                //兑换成功，改变会员积分
                String sql2 = "update t_members set integral = ? where id = ?";
                //获取预编译数据库操作对象
                ps = con.prepareStatement(sql2);
                ps.setInt(1, (inte - jifen));
                ps.setInt(2, memberId);
                ps.executeUpdate();
                System.out.println("兑换成功");
                return;
            }

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

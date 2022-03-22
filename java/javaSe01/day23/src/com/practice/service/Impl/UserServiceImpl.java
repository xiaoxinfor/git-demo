package com.practice.service.Impl;

import com.javasm.utils.JDBCUtils;
import com.practice.bean.User;
import com.practice.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-20:16
 * @Since:jdk1.8
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public User selectById(int id) {
        User user = null;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (con != null && !con.isClosed()) {
                String sql = "select * from tb_user where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setUName(rs.getString(2));
                    user.setSex(rs.getString(3));
                    user.setPhone(rs.getString(4));
                    user.setAddress(rs.getString(5));
                    user.setCreateTime(rs.getString(6));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, ps, rs);
        }
        return user;
    }

    @Override
    public void insert(User user) {
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            if (con != null && !con.isClosed()) {
                String sql = "insert into tb_user values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                User user1 = selectById(user.getId());
                if (user1 != null){
                    System.out.println("该信息以存在，添加失败");
                    return;
                }
                ps.setInt(1,user.getId());
                ps.setString(2,user.getUName());
                ps.setString(3,user.getSex());
                ps.setString(4,user.getPhone());
                ps.setString(5,user.getAddress());
                ps.setString(6,user.getCreateTime());

                int success = ps.executeUpdate();
                if (success > 0){
                    System.out.println("添加成功");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con,ps);
        }
    }

    @Override
    public List<User> select() {
        User user = null;
        List<User> list = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (con != null && !con.isClosed()) {
                String sql = "select * from tb_user";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt(1));
                    user.setUName(rs.getString(2));
                    user.setSex(rs.getString(3));
                    user.setPhone(rs.getString(4));
                    user.setAddress(rs.getString(5));
                    user.setCreateTime(rs.getString(6));
                    list.add(user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, ps, rs);
        }
        return list;
    }

    @Override
    public void delete(int id) {
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            if (con != null && !con.isClosed()){
                User user = selectById(id);
                if (user == null){
                    System.out.println("未查询到该用户信息，不能删除");
                    return;
                }
                String sql = "delete from tb_user where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1,id);
                int b = ps.executeUpdate();
                if (b > 0){
                    System.out.println("删除成功");
                }else {
                    System.out.println("删除失败");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con,ps);
        }
    }

    @Override
    public void update(int id) {
        Scanner scanner = new Scanner(System.in);
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            if (con != null && !con.isClosed()){
                User user = selectById(id);
                if (user == null){
                    System.out.println("未查询到该用户信息，不能修改");
                    return;
                }
                String sql = "update tb_user set uName = ?,sex = ?,phone = ?,address = ?,createTime = ? where id = ?";
                ps = con.prepareStatement(sql);
                System.out.println("请输入要修改的姓名、性别、电话、地址、时间");
                ps.setString(1,scanner.next());
                ps.setString(2,scanner.next());
                ps.setString(3,scanner.next());
                ps.setString(4,scanner.next());
                ps.setString(5,scanner.next());
                ps.setInt(6,id);
                int b = ps.executeUpdate();
                if (b > 0){
                    System.out.println("修改成功");
                }else {
                    System.out.println("修改失败");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con,ps);
        }
    }
}

package com.javasm.dao.impl;

import com.javasm.bean.User;
import com.javasm.dao.UserDao;
import com.javasm.utlis.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/7-22:13
 * @Since:jdk1.8
 * @Description:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(User user) {
        String sql = "insert into students values(?,?)";
        return JDBCUtils.executeUpdate(sql,user.getAct(),user.getPwd());
    }

    @Override
    public User select(String act) {
        String sql = "select * from students where act = ?";
        return JDBCUtils.get(sql,User.class,act);
    }

    @Override
    public <T> List<T> select() {
        String sql = "select * from students;";
        return JDBCUtils.executeQuery(sql,User.class);
    }
}

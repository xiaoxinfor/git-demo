package com.javasm.dao.impl;

import com.javasm.bean.Users;
import com.javasm.dao.UsersDao;
import com.javasm.utils.JDBCUtils;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-23:00
 * @Since:jdk1.8
 * @Description:
 */
public class UsersDaoImpl implements UsersDao {
    @Override
    public <T> T selectUser(String userName) {
        String sql = "select * from users where userName = ?";
        return JDBCUtils.get(sql,Users.class,userName);
    }
}

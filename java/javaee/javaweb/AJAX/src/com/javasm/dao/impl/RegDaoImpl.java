package com.javasm.dao.impl;

import com.javasm.bean.User;
import com.javasm.dao.RegDao;
import com.javasm.utils.JDBCUtils;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-14:10
 * @Since:jdk1.8
 * @Description:
 */
public class RegDaoImpl implements RegDao {
    @Override
    public User selectByAct(String act) {
        String sql = "select * from users where userName = ?";
        return JDBCUtils.get(sql,User.class,act);
    }

    @Override
    public int addUser(String act, String pwd) {
        String sql = "insert into users values(null,?,?)";
        return JDBCUtils.executeUpdate(sql,act,pwd);
    }
}

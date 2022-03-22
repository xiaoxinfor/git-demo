package com.javasm.dao.impl;

import com.javasm.bean.User;
import com.javasm.dao.UserDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/18-10:31
 * @Since:jdk1.8
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(User user) {
        String sql = "insert into tb_user values(?,?,?,?,?,?)";
        return JDBCUtils.executeUpdate(sql,user.getId(),user.getUName(),user.getSex(),user.getPhone(),user.getAddress(),user.getCreateTime());
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from tb_user where id = ?";
        return JDBCUtils.executeUpdate(sql,id);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update tb_user set uName = ?,sex = ?,phone = ?,address = ?,createTime = ? where id = ?";
        return JDBCUtils.executeUpdate(sql,user.getUName(),user.getSex(),user.getPhone(),
                user.getAddress(),user.getCreateTime(),user.getId());
    }

    @Override
    public <T> List<T> select() {
        String sql = "select * from tb_user";
        return JDBCUtils.find(sql,User.class);
    }

    @Override
    public <T> T selectByID(int id) {
        String sql = "select * from tb_user where id = ?";
        return JDBCUtils.get(sql,User.class,id);
    }
}

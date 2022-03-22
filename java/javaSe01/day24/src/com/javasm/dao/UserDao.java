package com.javasm.dao;

import com.javasm.bean.User;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/18-10:30
 * @Since:jdk1.8
 * @Description:
 */
public interface UserDao {
    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询用户信息
     *
     * @param
     * @param <T>
     * @return
     */
    <T> List<T> select();

    <T> T selectByID(int id);
}

package com.javasm.dao;

import com.javasm.bean.User;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/7-22:09
 * @Since:jdk1.8
 * @Description:
 */
public interface UserDao {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 用户登录
     *
     * @param act
     * @return
     */
    User select(String act);

    /**
     * 拿到所有的用户
     *
     * @return
     */
    <T> List<T> select();
}

package com.practice.service;

import com.practice.bean.User;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-20:15
 * @Since:jdk1.8
 * @Description:
 */
public interface UserService {
    User selectById(int id);
    /**
     * 添加数据
     *
     * @param user
     */
    void insert(User user);

    List<User> select();

    void delete(int id);

    void update(int id);
}

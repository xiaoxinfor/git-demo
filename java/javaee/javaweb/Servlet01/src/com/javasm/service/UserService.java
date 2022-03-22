package com.javasm.service;

import com.javasm.bean.User;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/9-19:42
 * @Since:jdk1.8
 * @Description:
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int reg(User user);

    /**
     * 用户登录
     *
     * @param act 账号
     * @return
     */
    User log(String act);

    /**
     * 拿到所有用户信息
     *
     * @return
     */
    List<User> getUsers();
}

package com.javasm.service.impl;

import com.javasm.bean.User;
import com.javasm.dao.UserDao;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.service.UserService;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/9-19:42
 * @Since:jdk1.8
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int reg(User user) {
        return userDao.add(user);
    }

    @Override
    public User log(String act) {
        return userDao.select(act);
    }

    @Override
    public List<User> getUsers() {
        return userDao.select();
    }
}

package com.javasm.service.impl;

import com.javasm.dao.UsersDao;
import com.javasm.dao.impl.UsersDaoImpl;
import com.javasm.service.UsersService;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-23:03
 * @Since:jdk1.8
 * @Description:
 */
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao = new UsersDaoImpl();
    @Override
    public <T> T userLog(String userName) {
        return usersDao.selectUser(userName);
    }
}

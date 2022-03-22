package com.javasm.service.impl;

import com.javasm.bean.User;
import com.javasm.dao.UserDao;
import com.javasm.service.UserService;
import com.javasm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-14:10
 * @Since:jdk1.8
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private SqlSession sqlSession = MyBatisUtils.getSqlSession();
    private UserDao userDao = sqlSession.getMapper(UserDao.class);
    @Override
    public User selectUser(String uName) {
        User user = userDao.selectUser(uName);
        return user;
    }
}

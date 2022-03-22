package com.javasm.dao;

import com.javasm.bean.Users;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-23:00
 * @Since:jdk1.8
 * @Description:
 */
public interface UsersDao {
    /**
     * 查询
     * @param userName
     * @return
     */
    <T> T selectUser(String userName);
}

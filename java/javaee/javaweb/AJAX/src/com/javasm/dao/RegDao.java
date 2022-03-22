package com.javasm.dao;

import com.javasm.bean.User;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-14:09
 * @Since:jdk1.8
 * @Description:
 */
public interface RegDao {
    /**
     * 通过账号查询
     *
     * @param act
     * @return
     */
    User selectByAct(String act);

    /**
     * 添加用户
     *
     * @param act
     * @param pwd
     * @return
     */
    int addUser(String act,String pwd);
}

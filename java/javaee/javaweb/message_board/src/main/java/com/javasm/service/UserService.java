package com.javasm.service;

import com.javasm.bean.User;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-14:08
 * @Since:jdk1.8
 * @Description:
 */
public interface UserService {
    /**
     * 登录（查询有没有该用户）
     *
     * @param uName
     * @return
     */
    User selectUser(String uName);
}

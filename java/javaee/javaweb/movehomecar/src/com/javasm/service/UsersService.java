package com.javasm.service;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-23:03
 * @Since:jdk1.8
 * @Description:
 */
public interface UsersService {
    /**
     * 登录
     *
     * @param userName
     * @param <T>
     * @return 管理员对象
     */
    <T> T userLog(String userName);
}

package com.javasm.dao;

import com.javasm.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/18-15:54
 * @Since:jdk1.8
 * @Description:
 */
public interface UserDao {
    User selectUser(@Param("uName") String uName);
}

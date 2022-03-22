package com.javayx.lambdaUser.userService;

import com.javayx.lambdaUser.bean.User;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-15:27
 * @Since:jdk1.8
 * @Description:
 */
@FunctionalInterface
public interface UserService {
    boolean gongNeng(User user, Scanner scanner);
}

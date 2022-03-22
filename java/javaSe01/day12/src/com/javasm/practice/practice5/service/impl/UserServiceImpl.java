package com.javasm.practice.practice5.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.ConsoleTable;
import cn.hutool.crypto.digest.MD5;
import com.javasm.practice.practice5.bean.User;
import com.javasm.practice.practice5.service.UserService;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-10:53
 * @Since:jdk1.8
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public User[] addUser(User[] users, Scanner scanner) {
        System.out.println("添加用户信息：");
        User user = new User();
        user.setId(User.indentityId++);
        System.out.println("请输入姓名");
        String inputName = scanner.next();
        user.setName(inputName);
        System.out.println("请输入密码");
        String inputPwd = scanner.next();
        user.setPwd(inputPwd);
        System.out.println("请输入身份证号");
        String inputIdCard = scanner.next();
        user.setIdCard(inputIdCard);
        System.out.println("请选择加密方式：1.base64   2.md5");
        int choose = scanner.nextInt();
        //只需手动添加姓名，密码，身份证号
        if (choose == 1) {
            user.setEncoderPwd(Base64.encode(inputPwd));
            user.setEncodIdCard(Base64.encode(inputIdCard));
        } else {
            MD5 md5 = MD5.create();
            user.setEncoderPwd(md5.digestHex(inputPwd));
            user.setEncodIdCard(md5.digestHex(inputIdCard));
        }
        //注册时间
        user.setRegTime(DateUtil.now());

        //扩容
        users = Arrays.copyOf(users, users.length + 1);
        //把添加的信息传入数组
        users[users.length -1] = user;
        return users;
    }

    @Override
    public void showUser(User[] users, Scanner scanner) {
        System.out.println("显示用户信息》》1.显示原信息    2.显示加密信息");
        System.out.println("请选择：");
        int choose = scanner.nextInt();

        //显示
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("用户编号", "姓名", "密码", "身份证号", "注册时间");
        for (User user : users) {
            if (choose == 1) {
                consoleTable.addBody(user.getId().toString(), user.getName(), user.getPwd(), user.getIdCard(), user.getRegTime());
            } else {
                consoleTable.addBody(user.getId().toString(), user.getName(), user.getEncoderPwd(), user.getEncodIdCard(), user.getRegTime());
            }
        }
        consoleTable.print();
    }
}

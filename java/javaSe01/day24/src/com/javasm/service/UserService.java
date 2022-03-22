package com.javasm.service;

import com.javasm.bean.User;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.dao.UserDao;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/18-11:13
 * @Since:jdk1.8
 * @Description:
 */
public class UserService {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDaoImpl();
    }
    /**
     * 添加用户信息
     */
    public void add(Scanner scanner){
        User user = new User();
        System.out.println("请输入用户ID");
        user.setId(scanner.nextInt());
        System.out.println("请输入用户姓名");
        user.setUName(scanner.next());
        System.out.println("请输入用户性别");
        user.setSex(scanner.next());
        System.out.println("请输入用户电话");
        user.setPhone(scanner.next());
        System.out.println("请输入用户地址");
        user.setAddress(scanner.next());
        System.out.println("请输入时间");
        user.setCreateTime(scanner.next());
        int i = userDao.addUser(user);
        if (i > 0) System.out.println("添加成功");
        else System.out.println("添加失败");
    }

    /**
     * 删除用户
     *
     * @param scanner
     */
    public void delete(Scanner scanner){
        System.out.println("请输入要删除的用户ID");
        int id = scanner.nextInt();
        int i = userDao.deleteUser(id);
        if (i>0) System.out.println("删除成功");
        else System.out.println("删除失败");
    }

    /**
     * 修改用户信息
     *
     * @param scanner
     */
    public void update(Scanner scanner){
        User user = new User();
        System.out.println("请输入要修改用户的ID");
        user.setId(scanner.nextInt());
        System.out.println("请输入修改后的姓名");
        user.setUName(scanner.next());
        System.out.println("请输入修改后的性别");
        user.setSex(scanner.next());
        System.out.println("请输入修改后的电话");
        user.setPhone(scanner.next());
        System.out.println("请输入修改后的地址");
        user.setAddress(scanner.next());
        System.out.println("请输入修改后的时间");
        user.setCreateTime(scanner.next());
        int i = userDao.updateUser(user);
        if (i > 0) System.out.println("修改成功");
        else System.out.println("修改失败");
    }

    public void cha(Scanner scanner){
        System.out.println("请选择您要查询的范围");
        System.out.println("1.全部");
        System.out.println("2.单个");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                List<User> list = userDao.select();
                System.out.println(list);
                break;
            case 2:
                System.out.println("请选择要查询的ID");
                int id = scanner.nextInt();
                User user = userDao.selectByID(id);
                System.out.println(user);
                break;
        }
    }
}

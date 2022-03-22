package com.javasm.service.impl;

import com.javasm.bean.User;
import com.javasm.service.UserService;

import javax.xml.transform.Source;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-17:03
 * @Since:jdk1.8
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void show(List<User> userList) {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void add(List<User> userList, Scanner scanner) {
        System.out.println("请输入用户的注册信息：");
        System.out.println("编号：");
        int id = scanner.nextInt();
        System.out.println("姓名：");
        String name = scanner.next();
        System.out.println("年龄：");
        int age = scanner.nextInt();
        User user = new User(id,name,age);
        userList.add(user);
    }

    @Override
    public void delete(List<User> userList, Scanner scanner) {
        System.out.println("请输入您要删除的用户编号");
        int id = scanner.nextInt();
        //得到该用户编号对应的索引
        int indexId = index(userList,id);
        if (indexId == -1){
            System.out.println("抱歉，该用户不存在");
            return;
        }
        User user = userList.remove(indexId);
        if (user == null){
            System.out.println("删除失败");
        }else {
            System.out.println("删除成功");
        }
    }


    @Override
    public void update(List<User> userList, Scanner scanner) {
        System.out.println("请输入您要修改的用户编号");
        int id = scanner.nextInt();
        //得到该用户编号对应的索引
        int indexId = index(userList,id);
        if (indexId == -1){
            System.out.println("抱歉，该用户不存在");
            return;
        }
        //根据索引获取用户
        User user = userList.get(indexId);
        System.out.println("修改之前用户信息" + user);
        System.out.println("请输入修改之后的姓名：");
        user.setName(scanner.next());
        System.out.println("请输入修改之后的年龄：");
        user.setAge(scanner.nextInt());
        User oldUser = userList.set(indexId,user);
        if (oldUser != null){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    /**
     * 根据用户编号查找对应索引
     */
    public Integer index(List<User> userList,int id){
        int indexId = -1;
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == id){
                indexId = i;
            }
        }
        return indexId;
    }
}

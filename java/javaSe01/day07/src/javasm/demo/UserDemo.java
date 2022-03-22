package javasm.demo;

import javasm.bean.User;

import javasm.bean.User;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-10:41
 * @Since:jdk1.8
 * @Description:
 */
public class UserDemo {
    public static void main(String[] args) {
        User[] users = new User[3];
        addUser(users);
        show(users);
    }

    /**
     * 添加用户
     */
    public static void addUser(User[] users){
        //创建用户
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < users.length; i++) {
            User user = new User();//循环创建新的用户对象
            //用set方法录入用户信息
            System.out.println("第" + (i + 1) + "个人的姓名：");
            String inputName = scanner.next();
            user.setName(inputName);
            System.out.println("第" + (i + 1) + "个人的年龄：");
            int inputAge = scanner.nextInt();
            user.setAge(inputAge);
            System.out.println("第" + (i + 1) + "个人的密码：");
            int inputPass = scanner.nextInt();
            user.setPassWord(inputPass);
            //将数据填入数组
            users[i] = user;
        }
    }
    /**
     * 显示输入的信息
     */
    public static void show(User[] users){
        System.out.println("姓名\t年龄\t密码");
        for (User user : users) {
            //取值
            System.out.println(user.getName() + "\t" + user.getAge() + "\t" + user.getPassWord());
        }
    }
}

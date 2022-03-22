package javasm.demo;

import javasm.bean.User1;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-14:06
 * @Since:jdk1.8
 * @Description:
 */
public class User1Demo {
    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.setAge(11);
        System.out.println(user1.getAge());
    }

}

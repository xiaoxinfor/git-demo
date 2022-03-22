package javasm.demo;

import javasm.bean.Computer;
import javasm.bean.Student;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-20:08
 * @Since:jdk1.8
 * @Description:
 */
public class StudentDemo {
    public static void main(String[] args) {
        stuTest();
    }

    public static void stuTest() {
        //先创建一个电脑对象
        Computer computer = new Computer("i7","联想",4);
        //创建学生对象
        Student stu1 = new Student("小明",101,"男",computer);
        stu1.eat();
        stu1.stu();
    }
}

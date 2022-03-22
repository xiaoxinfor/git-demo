package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-19:54
 * @Since:jdk1.8
 * @Description:学生类
 */
public class Student {
    public String name;//姓名
    public int id;//学号
    public String sex;
    public Computer computer;//电脑

    /**
     * 无参构造
     */
    public Student() {
    }

    /**
     * 全参构造
     */
    public Student(String name, int id, String sex,Computer computer) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.computer = computer;
    }

    //方法行为
    //吃饭
    public void eat() {
        System.out.println(this.name + "要去吃饭了");
    }

    //学习
    public void stu() {
        System.out.println(this.name + "再用" +this.computer.type + "的电脑学习");
    }
}
